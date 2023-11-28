package com.f.chapter20.class_;

import com.f.chapter20.Car;

/**
 * @author fzy
 * @date 2023/7/24 21:01
 * 得到Class对象的各种方式
 */
public class GetClass_ {
    public static void main(String[] args) throws Exception {
        //1.已知一个类的全类名，且该类在类路径下，则可通过 `Class` 类的静态方法 `forName()` 获取，
        // 可能抛出 `ClassNotFoundException`。
        String classPath = "com.f.chapter20.Car";   //classPath可通过配置文件读取
        Class carClass1 = Class.forName(classPath);
        System.out.println(carClass1);  //class com.f.chapter20.Car

        //2.若已知具体的类，通过类的 `class` 获取，该方式最为安全可靠，程序性能最高。
        Class carClass2 = Car.class;
        System.out.println(carClass2);  //class com.f.chapter20.Car

        //3.已知某个类的实例，调用该实例的 `getClass()` 方法获取 `Class` 对象。
        Car car = new Car();
        Class carClass3 = car.getClass();
        System.out.println(carClass3);  //class com.f.chapter20.Car

        //4.通过类加载器 `ClassLoader` 来获取到类的 `Class` 对象。
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class carClass4 = classLoader.loadClass(classPath);
        System.out.println(carClass4);  //class com.f.chapter20.Car

        //上面的四个类对象实际就是同一个对象
        System.out.println(carClass1.equals(carClass2) && carClass2.equals(carClass3) && carClass3.equals(carClass4));  //true

        //5.基本数据类型按如下方式得到 Class 类对象：`Class cls1 = 基本数据类型.class;`。
        Class<Integer> cls1 = int.class;
        System.out.println(cls1);   //int
        System.out.println(cls1.hashCode());    //1554874502

        //6.基本数据类型对应的包装类，可以通过 `.TYPE` 得到对应的 Class 类对象：`Class cls2 = 包装类.TYPE;`
        Class<Integer> cls2 = Integer.TYPE;
        System.out.println(cls2);   //int
        System.out.println(cls2.hashCode());    //1554874502
    }
}
