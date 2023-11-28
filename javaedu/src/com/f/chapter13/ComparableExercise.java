package com.f.chapter13;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author fzy
 * @date 2023/6/29 18:43
 */
public class ComparableExercise {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("tom", 20));
        people.add(new Person("jack", 18));
        people.add(new Person("jerry", 26));
        System.out.println("===排序前===");
        System.out.println(people);     //[Person{name='tom', age=20}, Person{name='jack', age=18}, Person{name='jerry', age=26}]
        Collections.sort(people);
        System.out.println("===排序后===");
        System.out.println(people);     //[Person{name='jack', age=18}, Person{name='tom', age=20}, Person{name='jerry', age=26}]
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.age;    //定制的排序方式，这里根据年龄来排序
        //return this.name.compareTo(p.name); //根据名称自然排序
    }
}
