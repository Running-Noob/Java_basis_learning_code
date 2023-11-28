package com.f.chapter13;

public class CharacterMethod {
    public static void main(String[] args) {
        System.out.println(Character.isDigit('1')); //判断是不是数字
        System.out.println(Character.isLetter('a')); //判断是不是字母
        System.out.println(Character.isUpperCase('A')); //判断是不是大写
        System.out.println(Character.isLowerCase('a')); //判断是不是小写
        System.out.println(Character.isWhitespace(' '));    //判断是不是空格

        System.out.println(Character.toUpperCase('a')); //转换为大写
        System.out.println(Character.toLowerCase('A')); //转换为小写
    }
}
