package com.f.chapter18.outputstream_;

import java.io.Serializable;

/**
 * @author fzy
 * @date 2023/7/11 21:41
 */
//Ϊ����Dog����������л��ر��棬����ʵ��Serializable�ӿ�
public class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
