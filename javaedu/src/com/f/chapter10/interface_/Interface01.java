package com.f.chapter10.interface_;

public class Interface01 {
    public static void main(String[] args) {
        A a = new A();
        a.myMethod();
    }
}

interface MyInterface {
    //Ĭ�Ϸ�����jdk 8.0 ֮��
    default public void myMethod(){
        System.out.println("MyInterface...");
    }
    //��̬������jdk 8.0 ֮��
    public static void hi(){
        System.out.println("hi...");
    }
    //�ڽӿ��У�ʡ���� abstract �ĳ��󷽷�
    public void hello();
}

class A implements MyInterface {
    @Override
    public void hello() {

    }
}