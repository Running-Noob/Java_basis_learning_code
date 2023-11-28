package com.f.chapter20.reflection;

import java.lang.reflect.Field;

/**
 * @author fzy
 * @date 2023/7/25 19:37
 * 通过反射访问类中的属性
 */
public class ReflectionAccessProperty {
    public static void main(String[] args) throws Exception {
        //1.先获取到Student类的Class对象
        Class<?> studentClass = Class.forName("com.f.chapter20.reflection.Student");
        //2.创建对象
        Object o = studentClass.newInstance();
        System.out.println(o);  //Student{age=0, name='null'}
        //3.使用反射得到 age 属性对象
        Field ageField = studentClass.getField("age");
        ageField.set(o, 88);    //通过反射来操作属性
        System.out.println(ageField.get(o));    //通过反射来得到属性的值   //88
        System.out.println(o);  //Student{age=88, name='null'}
        //4.使用反射操作 name 属性对象 -> (private + static)
        Field nameField = studentClass.getDeclaredField("name");
        nameField.setAccessible(true);  //通过暴破来使得可以访问 private 属性
        nameField.set(o, "小明");
        System.out.println(Student.getName());  //小明
        System.out.println(nameField.get(o));   //小明
        System.out.println(o);  //Student{age=88, name='小明'}
        nameField.set(null, "李华");  //因为name是static属性，所以参数可以传入 null
        System.out.println(nameField.get(null));    //获取属性值时能传入null，是因为 name 是 static 的 //李华
        System.out.println(Student.getName());  //李华
        System.out.println(o);  //Student{age=88, name='李华'}
    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static String getName() {
        return name;
    }
}
