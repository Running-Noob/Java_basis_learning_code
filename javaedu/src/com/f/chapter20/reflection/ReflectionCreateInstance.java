package com.f.chapter20.reflection;

import java.lang.reflect.Constructor;

/**
 * @author fzy
 * @date 2023/7/25 17:58
 * 通过反射创建对象
 */
public class ReflectionCreateInstance {
    public static void main(String[] args) throws Exception {
        //1.先获取到User类的Class对象
        Class<?> userClass = Class.forName("com.f.chapter20.reflection.User");
        //2.通过public的无参构造器创建实例
        Object o1 = userClass.newInstance();
        System.out.println(o1); //User{age=10, name='小明'}
        //3.通过public的有参构造器创建实例
        /**
         * 这里的Constructor对象就是
         *     public User(String name) {  //public的有参构造器
         *         this.name = name;
         *     }
         */
        // 3.1 先得到对应的构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        // 3.2 再创建实例，并传入实参
        Object o2 = constructor.newInstance("小强");
        System.out.println(o2); //User{age=10, name='小强'}
        //4.通过非public的有参构造器创建实例
        /**
         * 这里的Constructor对象就是
         *     private User(int age, String name) {    //private的有参构造器
         *         this.age = age;
         *         this.name = name;
         *     }
         */
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);
        //由于这里的 declaredConstructor 是 private 的，所以需要暴破(暴力破解)
        declaredConstructor.setAccessible(true);    //暴破，使用反射可以访问 private 构造器/方法/属性
        Object o3 = declaredConstructor.newInstance(100, "张三丰");
        System.out.println(o3); //User{age=100, name='张三丰'}
    }
}

class User {
    private int age = 10;
    private String name = "小明";

    public User() { //public的无参构造器
    }

    public User(String name) {  //public的有参构造器
        this.name = name;
    }

    private User(int age, String name) {    //private的有参构造器
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
