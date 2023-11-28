package com.f.chapter14.set;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author fzy
 * @date 2023/6/23 22:27
 */
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person p1 = new Person("1001", "AA");
        Person p2 = new Person("1003","CC");
        hashSet.add(p1);
        hashSet.add(p2);
        p1.setName("DD");
        hashSet.remove(p1);
        System.out.println(hashSet);    //1.这里输出什么？ -> [Person{id='1003', name='CC'}, Person{id='1001', name='DD'}]
        hashSet.add(new Person("1001","DD"));
        System.out.println(hashSet);    //2.这里输出什么？ -> [Person{id='1003', name='CC'}, Person{id='1001', name='DD'}, Person{id='1001', name='DD'}]
        hashSet.add(new Person("1001","AA"));
        System.out.println(hashSet);    //3.这里输出什么？ -> [Person{id='1003', name='CC'}, Person{id='1001', name='DD'}, Person{id='1001', name='DD'}, Person{id='1001', name='AA'}]
    }
}

class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}