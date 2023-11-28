package com.f.chapter10.innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.hi();

        //外部其他类访问静态内部类的成员的两种方式:
        //第一种方式：new Outer.Inner()：因为是静态内部类，所以可以直接用 Outer.Inner
        Outer.Inner inner01 = new Outer.Inner();
        inner01.say();

        //第二种方式：在外部类中，编写一个方法，返回Inner对象实例
        Outer.Inner inner02 = new Outer().getInnerInstance();
        inner02.say();
    }
}

class Outer {
    private int n1 = 10;
    private static String name = "张三";

    public static class Inner {
        private String name = "李四";

        public void say() {
            System.out.println("静态内部类的非静态变量name的值为：" + name);
            System.out.println("外部类的静态变量name的值为：" + Outer.name);
            System.out.println("=====================================");
            //不能直接访问外部类的非静态成员
            //System.out.println(n1); //无法访问
        }
    }

    public void hi() {
        System.out.print("我是类Outer的hi方法...\t");
        Inner inner = new Inner();
        inner.say();
    }

    public Inner getInnerInstance() {
        return new Inner();
    }
}
