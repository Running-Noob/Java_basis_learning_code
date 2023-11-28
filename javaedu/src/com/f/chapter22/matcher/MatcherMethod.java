package com.f.chapter22.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fzy
 * @date 2023/8/18 11:00
 * Matcher类的常用方法演示
 */
public class MatcherMethod {
    public static void main(String[] args) {
        //要匹配的内容
        String content = "hello, world! hello smith";
        //指定的正则表达式
        String regExp = "hello";
        //1.创建pattern对象
        Pattern pattern = Pattern.compile(regExp);
        //2.创建matcher对象
        Matcher matcher = pattern.matcher(content);
        //3.得到匹配结果
        while (matcher.find()) {
            System.out.println("============");
            //(1)`public int start()`：返回以前匹配的初始索引。
            System.out.println("匹配的内容的开始索引 = " + matcher.start());
            //(2)`public int end()`：返回最后匹配字符之后的偏移量。
            System.out.println("匹配的内容的结束索引 + 1 = " + matcher.end());
        }
        System.out.println();

        //(3)`public String replaceAll(String replacement)`：将与给定模式相匹配的输入序列的每个子序列替换为给定的字符串。方法返回的才是替换后的结果。
        // 将上面内容中的 hello 替换为 hi
        String newContent = matcher.replaceAll("hi");
        System.out.println(content);    //hello, world! hello smith
        System.out.println(newContent); //hi, world! hi smith
    }
}
