package com.f.chapter22.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fzy
 * @date 2023/8/17 19:08
 * 正则表达式捕获分组例子
 */
public class RegExp02 {
    public static void main(String[] args) {
        //给定的字符串
        String content = "s7788 nn1145java";

        /**
         * 非命名捕获
         *   (1)通过 matcher.group(0) 得到匹配到的字符串
         *   (2)通过 matcher.group(1) 得到匹配到的字符串的第一个分组的内容
         *   (3)通过 matcher.group(2) 得到匹配到的字符串的第二个分组的内容
         *   ......
         * */
        //String regExp = "(\\d\\d)(\\d\\d)";

        /**
         * 命名捕获
         *   (1)通过 matcher.group(0) 得到匹配到的字符串
         *   (2)通过 matcher.group(1) 或 matcher.group("g1") 得到匹配到的字符串的第一个分组的内容
         *   (3)通过 matcher.group(2) 或 matcher.group("g2") 得到匹配到的字符串的第二个分组的内容
         *   ......
         * */
        String regExp = "(?<g1>\\d\\d)(?<g2>\\d\\d)";

        //1.先创建一个Pattern对象, 即模式对象, 可以理解为就是一个正则表达式对象, 传入的参数为正则表达式
        Pattern pattern = Pattern.compile(regExp);
        //2.创建一个匹配器对象, 传入要处理的字符串
        //  matcher 匹配器按照 pattern(模式/样式) 到 content 文本中去匹配。
        Matcher matcher = pattern.matcher(content);
        //3.开始循环匹配
        while (matcher.find()) {    //如果找到就返回 true，否则返回 false。
            ////非命名捕获
            //System.out.println("找到: " + matcher.group(0));
            //System.out.println("第一个分组的内容: " + matcher.group(1));
            //System.out.println("第二个分组的内容: " + matcher.group(2));

            //命名捕获(既可以用上面非命名捕获的方法，也可以用自己独有的方法)
            System.out.println("找到: " + matcher.group(0));
            System.out.println("第一个分组的内容(编号获取): " + matcher.group(1));
            System.out.println("第一个分组的内容(命名获取): " + matcher.group("g1"));
            System.out.println("第二个分组的内容(编号获取): " + matcher.group(2));
            System.out.println("第二个分组的内容(命名获取): " + matcher.group("g2"));
        }
    }
}
