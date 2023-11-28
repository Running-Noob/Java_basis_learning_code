package com.f.chapter20.class_;

import java.lang.reflect.Method;

/**
 * @author fzy
 * @date 2023/7/25 16:51
 */
public class GetClassMethodInfo_ {
    public static void main(String[] args) throws Exception {
        //先得到对应类的 `Class` 类对象
        String classPath = "com.f.chapter20.Car";
        Class<?> carClass = Class.forName(classPath);
        //1.getModifiers：以 int 形式返回修饰符(默认修饰符为0、public为1、private为2、protected为4、static为8、final为16)。
        //toString 方法的修饰符的值 = 1
        //m3 方法的修饰符的值 = 0
        //m2 方法的修饰符的值 = 4
        //m1 方法的修饰符的值 = 1
        //m4 方法的修饰符的值 = 2
        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + " 方法的修饰符的值 = " + declaredMethod.getModifiers());
        }

        //2.getReturnType：返回方法所对应的类的 Class 对象
        //toString 方法的类型 = class java.lang.String
        //m1 方法的类型 = void
        //m2 方法的类型 = void
        //m3 方法的类型 = void
        //m4 方法的类型 = void
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + " 方法的类型 = " + declaredMethod.getReturnType());
        }

        //3.getParameterTypes：以 Class[] 形式返回方法的形参的类型的数组
        //toString 方法的形参类型 =
        //m3 方法的形参类型 =
        //m1 方法的形参类型 =
        //m4 方法的形参类型 =
        //m2 方法的形参类型 =
        //因为这几个方法的参数都为空，所以parameterTypes都是空数组
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod.getName() + " 方法的形参类型 = ");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType + " ");
            }
            System.out.println();
        }
    }
}
