package com.f.chapter15.customgeneric;

/**
 * @author fzy
 * @date 2023/6/29 21:41
 */
public class CustomGenericMethod {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("����", 100); //�����÷���ʱ������������������ͻ�ȷ������
    }
}

class Car {
    public void drive() {   //��ͨ����

    }

    public <T, R> void fly(T t, R r) {  //���ͷ���
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}