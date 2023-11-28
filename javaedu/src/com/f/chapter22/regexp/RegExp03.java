package com.f.chapter22.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fzy
 * @date 2023/8/17 19:19
 * 正则表达式非捕获分组例子
 */
public class RegExp03 {
    public static void main(String[] args) {
        //给定的字符串
        String content = "hello小白狗 world小白猫 小白鸽! 小白";

        /**
         * 给定的非捕获正则表达式(?:pattern)
         * 匹配 `pattern` 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
         * 这对于用 `"or"` 字符 (`"|"`) 组合模式部件的情况很有用。
         * 例如，`'industr(?:y|ies)'` 是比 `'industry|industries'` 更经济的表达式。
         */
        //传统的方式: String regExp = "小白狗|小白猫|小白鸽";
        //String regExp = "小白(?:狗|猫|鸽)";  //String regExp = "小白(狗|猫|鸽)"; 好像也行

        /**
         * 给定的非捕获正则表达式(?=pattern)
         * 它是一个非捕获匹配。例如，`'Windows (?=95|98|NT|2000)'` 匹配 `"Windows 2000"` 中的 `"Windows"`，
         * 但不匹配 `"Windows 3.1"` 中的 `"Windows"`。
         */
        //找到“小白”关键字，但是只匹配“小白狗”或者“小白猫”中的“小白”
        //String regExp = "小白(?=狗|猫)";

        /**
         * 给定的非捕获正则表达式(?!pattern)
         * 该表达式匹配不处于匹配 `pattern` 的字符串的起始点的搜索字符串。它是一个非捕获匹配。
         * 例如，`'Windows (?!95|98|NT|2000)'` 匹配 `"Windows 3.1"` 中的 `"Windows"`，
         * 但不匹配 `"Windows 2000"` 中的 `"Windows"`。
         */
        //找到“小白”关键字，但是不匹配“小白狗”或者“小白猫”中的“小白”，匹配其他小白
        String regExp = "小白(?!狗|猫)";

        //1.先创建一个Pattern对象, 即模式对象, 可以理解为就是一个正则表达式对象, 传入的参数为正则表达式
        Pattern pattern = Pattern.compile(regExp);
        //2.创建一个匹配器对象, 传入要处理的字符串
        //  matcher 匹配器按照 pattern(模式/样式) 到 content 文本中去匹配。
        Matcher matcher = pattern.matcher(content);
        //3.开始循环匹配
        while (matcher.find()) {    //如果找到就返回 true，否则返回 false。
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
