package com.f.chapter10;

public class CodeBlockDetail {
    public static void main(String[] args) {
        new B01();
    }
}

class A01 {
    private static int n1 = getVal01();

    static {
        System.out.println("A01�ĵ�һ����̬�����...");  //(2)
    }

    {
        System.out.println("A01�ĵ�һ����ͨ�����...");  //(5)
    }

    public int n2 = getVal02();

    public static int getVal01() {
        System.out.println("getVal01()...");            //(1)
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02()...");            //(6)
        return 20;
    }

    public A01() {
        //super();
        //������ͨ�����
        System.out.println("A01�Ĺ�����...");           //(7)
    }
}

class B01 extends A01 {
    static {
        System.out.println("B01�ĵ�һ����̬�����...");  //(3)
    }

    private static int n3 = getVal03();

    public int n4 = getVal04();

    {
        System.out.println("B01�ĵ�һ����ͨ�����...");  //(9)
    }

    public static int getVal03() {
        System.out.println("getVal03()...");        //(4)
        return 30;
    }

    public int getVal04() {
        System.out.println("getVal04()...");        //(8)
        return 40;
    }

    public B01() {
        //super();
        //������ͨ�����
        System.out.println("B01�Ĺ�����...");       //(10)
    }
}