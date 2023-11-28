package com.f.chapter15.generic;

/**
 * @author fzy
 * @date 2023/6/28 20:42
 */
public class GenericDetail {
    public static void main(String[] args) {
        //1. ��ΪaDog�ķ���ָ��ΪA���ͣ������ڹ������д���A���󣬱���ͨ��
        Dog<A> aDog = new Dog<>(new A());

        //2. ��ΪbDog�ķ���ָ��ΪA���ͣ�����ΪB��A�����࣬�����ڹ������д���B���󣬱���Ҳͨ��
        Dog<A> bDog = new Dog<>(new B());

        //3. ��ΪcDog�ķ���ָ��ΪA���ͣ�����C��Aû�й�ϵ�������ڹ������д���C���󣬱������
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