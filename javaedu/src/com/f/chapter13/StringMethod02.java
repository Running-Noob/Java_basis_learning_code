package com.f.chapter13;

public class StringMethod02 {
    public static void main(String[] args) {
        String name = "小明";
        int age = 10;
        double score = 100 / 3;
        String formatStr = "我的姓名是%s 年龄是%d 成绩是%.2f";
        String info = String.format(formatStr, name, age, score);
        System.out.println(info);
    }
}
