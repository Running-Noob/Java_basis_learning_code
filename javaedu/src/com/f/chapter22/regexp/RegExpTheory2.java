package com.f.chapter22.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fzy
 * @date 2023/8/15 21:56
 * 分析Java正则表达式的底层实现(引入分组)
 */
public class RegExpTheory2 {
    public static void main(String[] args) {
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。" +
                "2001年9月24日，J2EE1.3发布。2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，" +
                "其多了近62%的类和接口。在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、" +
                "全新的I/OAPI、正则表达式、日志与断言。2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。" +
                "为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），代号为“Tiger”，" +
                "Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、" +
                "格式化I/O及可变参数。";
        //分组：例如下面的 (\\d\\d)(\\d\\d)，正则表达式中有 () 就表示分组，第一个 () 代表第一组，第二个 () 代表第二组
        String regExp = "(\\d\\d)(\\d\\d)";
        //1.先创建一个Pattern对象, 即模式对象, 可以理解为就是一个正则表达式对象, 传入的参数为正则表达式
        Pattern pattern = Pattern.compile(regExp);
        //2.创建一个匹配器对象, 传入要处理的字符串
        //  matcher 匹配器按照 pattern(模式/样式) 到 content 文本中去匹配。
        Matcher matcher = pattern.matcher(content);
        //3.开始循环匹配
        /*
         * matcher.find() 完成的任务 (考虑分组)
         * (1)根据指定的正则表达式，定位满足规则的子字符串
         * (2)找到后，将子字符串 “开始的索引位置” 记录到 matcher 对象的属性 int[] groups 中
         *       同时将子字符串 “结束的索引位置 + 1” 记录到 groups 中
         *      (2.1)仍以第一个找到的 2000 为例，groups[0] = 0 (因为2的索引位置为0)，groups[1] = 4 (因为最后一个0的索引位置为3，3+1=4)
         *          但是因为引入了分组，所以还会将第一组 (对应20)、第二组 (对应00) 的开始和结束索引位置也记录下来
         *      (2.2)第一组匹配到的字符串 (20)，groups[2] = 0 (因为2的索引位置为0)，groups[3] = 2 (因为20的最后一个0的索引位置为1，1+1=2)
         *      (2.3)第二组匹配到的字符串 (00)，groups[4] = 2 (因为第一个0的索引位置为2)，groups[5] = 4 (因为第二个0的索引位置为4，3+1=4)
         *          如果有更多的分组，以此类推...
         * (3)同时记录 oldLast 的值为 “结束的索引位置 + 1”，即下次执行 find 方法时，就从 oldLast 开始继续向下匹配
         * */
        while (matcher.find()) {    //如果找到就返回 true，否则返回 false。
            //匹配到的内容可以通过 matcher.group 得到
            /**
             *    public String group(int group) {
             *         if (first < 0)
             *             throw new IllegalStateException("No match found");
             *         if (group < 0 || group > groupCount())
             *             throw new IndexOutOfBoundsException("No group " + group);
             *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
             *             return null;
             *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
             *     }
             *     (1)根据 groups[0] 和 groups[1] 记录的位置，从 content 中截取子字符串(截取规则为左闭右开的规则)并返回
             *          以第一个找到的 2000 为例，groups[0] = 0，groups[1] = 4，所以返回的就是 "2000"
             *          因为引入了分组，所以还可以得到匹配到的子字符串的分组的内容
             *          matcher.group(0) 表示得到 groups[0] 和 groups[1] 所对应的子字符串，即表示返回匹配到的子字符串的所有内容。
             *          matcher.group(1) 表示得到 groups[2] 和 groups[3] 所对应的子字符串，即表示返回匹配到的子字符串的第 `1` 个分组的内容。
             *          matcher.group(2) 表示得到 groups[4] 和 groups[5] 所对应的子字符串，即表示返回匹配到的子字符串的第 `2` 个分组的内容。
             *          以此类推...
             *          从 return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString(); 也可以看出来
             *     (2)然后继续向下匹配，将会匹配到 2001，此时会更新 groups[0] 和 groups[1] 的值，即更新后
             *          groups[0] = 65，groups[1] = 69，所以返回的就是 "2001"，其分组也和上面类似
             *          同样的，oldLast 的值也会进行更新
             */
            System.out.print("找到匹配内容: " + matcher.group(0) + "\t");
            System.out.print("匹配内容的第一组: " + matcher.group(1) + "\t");
            System.out.println("匹配内容的第二组: " + matcher.group(2));
        }
    }
}