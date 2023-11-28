package com.f.chapter13;

public class Integer01 {
    public static void main(String[] args) {
        //演示 int <---> Integer 的装箱与拆箱
        //jdk5以前用的是手动装箱和手动拆箱的方式
        int n1 = 100;
        Integer integer1 = new Integer(n1);     //手动装箱方式1
        Integer integer2 = Integer.valueOf(n1);     //手动装箱方式2
        int n2 = integer1.intValue();       //手动拆箱方式

        //jdk5以后可以用自动装箱和自动拆箱
        Integer integer3 = n2;      //自动装箱：底层使用的就是 Integer.valueOf(n2)
        int n3 = integer3;          //自动拆箱：底层使用的就是 intValue() 方法
    }
}
