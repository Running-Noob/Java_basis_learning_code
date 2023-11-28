package com.f.chapter20.class_;

import java.lang.reflect.Constructor;

/**
 * @author fzy
 * @date 2023/7/25 17:06
 */
public class GetClassConstructorInfo_ {
    public static void main(String[] args) throws Exception {
        //先得到对应类的 `Class` 类对象
        String classPath = "com.f.chapter20.Car";
        Class<?> carClass = Class.forName(classPath);
        //1.getModifiers：以 int 形式返回修饰符(默认修饰符为0、public为1、private为2、protected为4、static为8、final为16)。
        //private com.f.chapter20.Car(java.lang.String,double,java.lang.String) 构造器的修饰符的值 = 2
        //com.f.chapter20.Car(java.lang.String,double) 构造器的修饰符的值 = 0
        //protected com.f.chapter20.Car(java.lang.String) 构造器的修饰符的值 = 4
        //public com.f.chapter20.Car() 构造器的修饰符的值 = 1
        Constructor<?>[] declaredConstructors = carClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor + " 构造器的修饰符的值 = " + declaredConstructor.getModifiers());
        }

        //2.getParameterTypes：以 Class[] 形式返回构造器的形参的类型的数组
        //private com.f.chapter20.Car(java.lang.String,double,java.lang.String) 构造器的形参类型 = class java.lang.String double class java.lang.String
        //com.f.chapter20.Car(java.lang.String,double) 构造器的形参类型 = class java.lang.String double
        //protected com.f.chapter20.Car(java.lang.String) 构造器的形参类型 = class java.lang.String
        //public com.f.chapter20.Car() 构造器的形参类型 =
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.print(declaredConstructor + " 构造器的形参类型 = ");
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType + " ");
            }
            System.out.println();
        }
    }
}
