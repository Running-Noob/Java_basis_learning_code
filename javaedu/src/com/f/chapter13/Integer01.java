package com.f.chapter13;

public class Integer01 {
    public static void main(String[] args) {
        //��ʾ int <---> Integer ��װ�������
        //jdk5��ǰ�õ����ֶ�װ����ֶ�����ķ�ʽ
        int n1 = 100;
        Integer integer1 = new Integer(n1);     //�ֶ�װ�䷽ʽ1
        Integer integer2 = Integer.valueOf(n1);     //�ֶ�װ�䷽ʽ2
        int n2 = integer1.intValue();       //�ֶ����䷽ʽ

        //jdk5�Ժ�������Զ�װ����Զ�����
        Integer integer3 = n2;      //�Զ�װ�䣺�ײ�ʹ�õľ��� Integer.valueOf(n2)
        int n3 = integer3;          //�Զ����䣺�ײ�ʹ�õľ��� intValue() ����
    }
}
