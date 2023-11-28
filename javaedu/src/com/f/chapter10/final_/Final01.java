package com.f.chapter10.final_;

public class Final01 {
    public static void main(String[] args) {
        /*
        //第 3 种情况：此时该属性值不能修改
        E.TAX_RATE = 0.01;
        */
    }
}

final class A {
}

/*
//第 1 种情况：此时 B 不能继承 A
class B extends A{ }
*/

class C {
    public final void hi() {
    }
}

class D extends C {
/*
    //第 2 种情况：此时 C 中的方法 hi() 不能被重写
    @Override
    public void hi() {}
*/
}

class E {
    public static final double TAX_RATE = 0.08;
}

class F {
    private final int NUM = 1;
    public void hi(){
        /*
        //第 4 种情况：此时该局部变量不能修改，这时该变量也称为局部常量
        NUM = 2;
        */
    }
}