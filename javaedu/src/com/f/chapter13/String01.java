package com.f.chapter13;

public class String01 {
    public static void main(String[] args) {
        //��װ��(��IntegerΪ��)�� String ���໥ת��
        //Integer -> String
        Integer i1 = 100;           //�Զ�װ��
        String s1 = i1 + "";        //��ʽ1
        String s2 = i1.toString();  //��ʽ2
        String s3 = String.valueOf(i1); //��ʽ3
        //String -> Integer
        Integer i2 = Integer.parseInt(s1);  //��ʽ1 parseInt�������ص��� int �������ݣ��������ﻹ�õ����Զ�װ�䣬�� int װ��Ϊ Integer
        Integer i3 = Integer.valueOf(s1);   //��ʽ2
    }
}
