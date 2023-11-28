package com.f.chapter20.class_;

import java.lang.reflect.Field;

/**
 * @author fzy
 * @date 2023/7/25 16:29
 */
public class GetClassFieldInfo_ {
    public static void main(String[] args) throws Exception {
        //先得到对应类的 `Class` 类对象
        String classPath = "com.f.chapter20.Car";
        Class<?> carClass = Class.forName(classPath);
        //1.getModifiers：以 int 形式返回修饰符(默认修饰符为0、public为1、private为2、protected为4、static为8、final为16)。
        // 如果是 public static 则返回 1+8=9...
        //brand 属性的修饰符的值 = 1
        //price 属性的修饰符的值 = 4
        //color 属性的修饰符的值 = 0
        //speed 属性的修饰符的值 = 2
        Field[] declaredFields = carClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + " 属性的修饰符的值 = " + declaredField.getModifiers());
        }

        //2.getType：返回属性所对应的类的 Class 对象
        //brand 属性的类型 = class java.lang.String
        //price 属性的类型 = double
        //color 属性的类型 = class java.lang.String
        //speed 属性的类型 = double
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + " 属性的类型 = " + declaredField.getType());
        }
    }
}
