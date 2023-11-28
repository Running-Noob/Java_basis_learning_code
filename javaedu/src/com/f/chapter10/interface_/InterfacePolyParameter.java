//package com.f.Chapter10.interface_;
//
//public class InterfacePolyParameter {
//    public static void main(String[] args) {
//        //接口的多态体现
//        //接口类型的变量 ia 可以指向 实现了IA接口的类 的对象实例
//        IA ia = new Bicycle();
//        ia = new Car();
//
//        //继承的多态体现
//        //父类的变量 base 可以指向继承了父类的子类 Sub 的对象实例
//        Base base = new Sub();
//    }
//}
//
//interface IA { }
//
//class Bicycle implements IA { }
//
//class Car implements IA { }
//
//class Base { }
//
//class Sub extends Base { }