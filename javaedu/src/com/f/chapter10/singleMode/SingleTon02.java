package com.f.chapter10.singleMode;

public class SingleTon02 {
    public static void main(String[] args) {
        //通过方法获取对象实例
        AA aa = AA.getaInstance();
        System.out.println(aa);
    }
}

class AA {
    private String name;

    //2. 类内部定义一个 static 静态属性对象
    private static AA aaInstance;

    //1. 构造器私有化，此时在 main 函数中，已经不能直接 new 对象了
    private AA(String name) {
        System.out.println("构造器 AA 被调用...");
        this.name = name;
    }

    //3. 向外暴露一个静态的公共方法；-> getInstance
    public static AA getaInstance() {
        if (aaInstance == null) {   //如果对象还没有创建
            aaInstance = new AA("aa");
        }
        return aaInstance;
    }
}