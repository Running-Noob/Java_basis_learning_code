package com.f.chapter13;

public class StringMethod01 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = s1.replace("he","ol");
        String s3 = s1.concat(",world!");
        System.out.println(s1);     //s1指向的常量池中的 “hello”对象 并没有发生变化
        System.out.println(s2);     //是在堆中创建了一个新的 String 对象，对象的 value 指向常量池中的 “olllo”
        System.out.println(s3);
    }
}
