package com.f.chapter15.customgeneric;

/**
 * @author fzy
 * @date 2023/6/29 21:41
 */
public class CustomGenericMethod {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宾利", 100); //当调用方法时，传入参数，编译器就会确定类型
    }
}

class Car {
    public void drive() {   //普通方法

    }

    public <T, R> void fly(T t, R r) {  //泛型方法
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}