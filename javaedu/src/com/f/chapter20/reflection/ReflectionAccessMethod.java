package com.f.chapter20.reflection;

import java.lang.reflect.Method;

/**
 * @author fzy
 * @date 2023/7/25 20:19
 * 通过反射访问类中的方法
 */
public class ReflectionAccessMethod {
    public static void main(String[] args) throws Exception {
        //1.先获取到Boss类的Class对象
        Class<?> bossClass = Class.forName("com.f.chapter20.reflection.Boss");
        //2.创建对象
        Object o = bossClass.newInstance();
        //3.调用public的hi方法
        // 3.1 得到 hi 方法对象
        Method hiMethod = bossClass.getMethod("hi", String.class);
        // 3.2 通过 invoke 调用 hi 方法
        hiMethod.invoke(o, "Jack"); //hi, Jack
        //4.调用private static的say方法
        Method sayMethod = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        sayMethod.setAccessible(true);  //因为say方法是私有的，所以需要暴破
        System.out.println(sayMethod.invoke(o, 100, "小明", 'A'));    //100 小明 A
        //因为say方法是Boss类的静态方法，所以传入null也可以
        System.out.println(sayMethod.invoke(null, 200, "李华", 'B')); //200 李华 B
        //5.在反射中，如果方法有返回值，统一返回 Object，但是返回值的运行类型和方法定义的返回类型一致
        Object returnVal = sayMethod.invoke(null, 300, "张三", 'C');
        System.out.println(returnVal.getClass());   //class java.lang.String
    }
}

class Boss {
    public int age;
    private static String name;

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi, " + s);
    }
}