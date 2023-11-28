package com.f.chapter10;

public class VisitStatic {
    public static void main(String[] args) {
        //注意：类变量是随着类的加载而创建的，所以即使没有创建对象实例也可以访问
        System.out.println(A.name);     //输出 "A"    推荐使用
        A a = new A();
        System.out.println(a.name);     //输出 "A"
    }
}

class A {
    public static String name = "A";
}