package com.f.chapter10;

public class TestMainParam {
    public static void main(String[] args) {
        //���� args
        for (int i = 0; i < args.length; i++) {
            System.out.println("��" + (i + 1) + "������Ϊ��" + args[i]);
        }
    }
}