package com.f.chapter15.generic;

/**
 * @author fzy
 * @date 2023/6/28 20:42
 */
public class GenericDetail {
    public static void main(String[] args) {
        //1. 因为aDog的泛型指定为A类型，所以在构造器中传入A对象，编译通过
        Dog<A> aDog = new Dog<>(new A());

        //2. 因为bDog的泛型指定为A类型，又因为B是A的子类，所以在构造器中传入B对象，编译也通过
        Dog<A> bDog = new Dog<>(new B());

        //3. 因为cDog的泛型指定为A类型，但是C和A没有关系，所以在构造器中传入C对象，编译错误
        //Dog<A> cDog = new Dog<>(new C());
    }
}

class A {
}

class B extends A {
}

class C {
}

class Dog<E> {
    E e;

    public Dog(E e) {
        this.e = e;
    }
}