package com.f.chapter12.exception_;

public class ClassCastException_ {
    public static void main(String[] args) {
        A a = new B();  //����ı���ָ������Ķ��� -> ����ת��
        B b = (B)a;     //����ת��
        //C c = (B)a;     //ClassCastException
    }
}

class A {
}

class B extends A {
}

class C extends A {
}