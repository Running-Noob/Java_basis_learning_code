package com.f.chapter20;

/**
 * @author fzy
 * @date 2023/7/24 17:01
 */
public class Cat {
    private String name = "Milk";
    public int age = 10;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
        System.out.println(name + " say hi!");
    }

    public void showAge() {
        System.out.println(name + " is " + age + " years old.");
    }
}
