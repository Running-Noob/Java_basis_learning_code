package com.f.chapter22.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fzy
 * @date 2023/8/18 11:59
 * 反向引用例子
 */
public class RegExp04 {
    public static void main(String[] args) {
        String content = "hello, world123443222221!";
        //String regExp = "(\\d)\\1"; //要匹配两个连续的相同数字
        //String regExp = "(\\d)\\1{4}";  //要匹配五个连续的相同数字
        String regExp = "(\\d)(\\d)\\2\\1"; //要匹配个位与千位相同、十位与百位相同的数字
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
