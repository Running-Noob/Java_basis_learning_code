package com.f.chapter12.customexception_;

public class CustomException {
    public static void main(String[] args) {
        int age = 10;
        //Ҫ�����䷶Χ��18-120֮�䣬�����׳�һ���Զ����쳣
        if (!(age >= 18 && age <= 120)) {
            throw new AgeException("������Ҫ������18-120֮��...");
        }
        System.out.println("���䷶Χ��ȷ...");
    }
}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}