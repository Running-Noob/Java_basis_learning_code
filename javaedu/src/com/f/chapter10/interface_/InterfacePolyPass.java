package com.f.chapter10.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向 实现了该接口的类 的对象实例
        IB ib = new Teacher();
        //如果接口 IB 继承了 IA，那么 IA 的变量也可以指向 实现了接口IB的类 的对象实例
        //亦即，实际上就相当于 Teacher 类也要实现 IA 接口
        IA ia = new Teacher();
    }
}

interface IA {}
interface IB extends IA {}
class Teacher implements IB {}