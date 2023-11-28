package com.f.chapter22.pattern;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * @author fzy
 * @date 2023/8/18 10:45
 * Pattern类的常用方法演示
 */
public class PatternMethod {
    @Test
    //1.matches方法，用于整体匹配，在验证输入的字符串是否满足条件时使用，
    //      满足时返回true，否则返回false
    /**
     *     public static boolean matches(String regex, CharSequence input) {
     *         Pattern p = Pattern.compile(regex);
     *         Matcher m = p.matcher(input);
     *         return m.matches();
     *     }
     *     底层调用的是 Matcher 类的 matches 方法
     */
    public void patternMatches() {
        String content = "hello, world!";
        String regExp = "hello.*";
        boolean matches = Pattern.matches(regExp, content);
        System.out.println("整体匹配为: " + matches);
    }
}