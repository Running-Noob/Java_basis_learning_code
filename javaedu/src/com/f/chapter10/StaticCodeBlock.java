package com.f.chapter10;

public class StaticCodeBlock {
    public static void main(String[] args) {
        /*输出结果为：
         * "AA的静态代码块..."
         * "BB的静态代码块..."
         * "AA的普通代码块..."
         * "BB的普通代码块..."
         * "AA的普通代码块..."
         * "BB的普通代码块..."*/
        //BB bb1 = new BB();
        //BB bb2 = new BB();
        CC cc = new CC();
    }
}

class AA {
    //static {
    //    System.out.println("AA的静态代码块...");
    //}
    //
    //{
    //    System.out.println("AA的普通代码块...");
    //}

    public AA() {
        System.out.println("AA的构造函数");
    }

    public static void hi() {

    }
}

class BB extends AA {
    //static {
    //    System.out.println("BB的静态代码块...");
    //}
    //
    //{
    //    System.out.println("BB的普通代码块...");
    //}

    public BB() {
        System.out.println("BB的构造函数");
    }
}

class CC extends BB{
    static {
        System.out.println("CC的静态代码块...");
    }
}