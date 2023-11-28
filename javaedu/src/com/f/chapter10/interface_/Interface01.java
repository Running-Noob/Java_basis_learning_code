package com.f.chapter10.interface_;

public class Interface01 {
    public static void main(String[] args) {
        A a = new A();
        a.myMethod();
    }
}

interface MyInterface {
    //默认方法，jdk 8.0 之后
    default public void myMethod(){
        System.out.println("MyInterface...");
    }
    //静态方法，jdk 8.0 之后
    public static void hi(){
        System.out.println("hi...");
    }
    //在接口中，省略了 abstract 的抽象方法
    public void hello();
}

class A implements MyInterface {
    @Override
    public void hello() {

    }
}