package com.f.chapter13;

public class StringMethod02 {
    public static void main(String[] args) {
        String name = "С��";
        int age = 10;
        double score = 100 / 3;
        String formatStr = "�ҵ�������%s ������%d �ɼ���%.2f";
        String info = String.format(formatStr, name, age, score);
        System.out.println(info);
    }
}
