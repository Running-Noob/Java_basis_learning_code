package com.f.chapter13;

public class StringMethod01 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = s1.replace("he","ol");
        String s3 = s1.concat(",world!");
        System.out.println(s1);     //s1ָ��ĳ������е� ��hello������ ��û�з����仯
        System.out.println(s2);     //���ڶ��д�����һ���µ� String ���󣬶���� value ָ�������е� ��olllo��
        System.out.println(s3);
    }
}
