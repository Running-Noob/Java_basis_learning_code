package com.f.chapter12.exception_;

public class ClassCastException_ {
    public static void main(String[] args) {
        A a = new B();  //父类的变量指向子类的对象 -> 向上转型
        B b = (B)a;     //向下转型
        //C c = (B)a;     //ClassCastException
    }
}

class A {
}

class B extends A {
}

class C extends A {
}