package com.f.chapter10.abstract_;

public class Abstract {
    public static void main(String[] args) {

    }
}

//由于该类中存在抽象方法 eat，所以该类需要为抽象类
abstract class Animal {
    public String name;

    //不同的动物吃的东西不一样，所以这里仅将 eat 方法定义为抽象方法
    public abstract void eat();
}