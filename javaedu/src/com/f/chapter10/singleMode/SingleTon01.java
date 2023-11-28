package com.f.chapter10.singleMode;

public class SingleTon01 {
    public static void main(String[] args) {
        //通过方法获取对象实例
        A a = A.getaInstance();
    }
}

class A{
    private String name;

    //2. 在类的内部创建对象
    private static A aInstance = new A("a");

    //1. 构造器私有化，此时在 main 函数中，已经不能直接 new 对象了
    private A(String name) {
        this.name = name;
    }

    //3. 向外暴露一个静态的公共方法；-> getInstance
    public static A getaInstance(){
        return A.aInstance;
    }
}