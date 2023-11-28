package com.f.chapter22.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fzy
 * @date 2023/8/15 19:29
 * 分析Java正则表达式的底层实现
 */
public class RegExpTheory {
    public static void main(String[] args) {
        //给定一段字符串，找出所有四个数字连在一起的子串
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。" +
                "2001年9月24日，J2EE1.3发布。2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，" +
                "其多了近62%的类和接口。在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、" +
                "全新的I/OAPI、正则表达式、日志与断言。2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。" +
                "为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），代号为“Tiger”，" +
                "Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、" +
                "格式化I/O及可变参数。";
        //正则表达式, 匹配四个数字连在一起的子串
        //说明: \\d 表示一个任意的数字
        String regExp = "\\d\\d\\d\\d";
        //1.先创建一个Pattern对象, 即模式对象, 可以理解为就是一个正则表达式对象, 传入的参数为正则表达式
        Pattern pattern = Pattern.compile(regExp);
        //2.创建一个匹配器对象, 传入要处理的字符串
        //  matcher 匹配器按照 pattern(模式/样式) 到 content 文本中去匹配。
        Matcher matcher = pattern.matcher(content);
        //3.开始循环匹配
        /*
         * matcher.find() 完成的任务
         * (1)根据指定的正则表达式，定位满足规则的子字符串
         * (2)找到后，将子字符串 “开始的索引位置” 记录到 matcher 对象的属性 int[] groups 中
         *       以第一个找到的 2000 为例，groups[0] = 0 (因为2的索引位置为0)
         *       同时将子字符串 “结束的索引位置 + 1” 记录到 groups 中
         *       以第一个找到的 2000 为例，groups[1] = 4 (因为最后一个0的索引位置为3，3+1=4)
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
             *     (2)然后继续向下匹配，将会匹配到 2001，此时会更新 groups[0] 和 groups[1] 的值，即更新后
             *          groups[0] = 65，groups[1] = 69，所以返回的就是 "2001"
             *          同样的，oldLast 的值也会进行更新
             */
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
