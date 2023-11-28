package com.f.chapter20.class_;

import com.f.chapter20.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author fzy
 * @date 2023/7/24 18:13
 * Class类的常用方法
 */
public class Class01 {
    public static void main(String[] args) throws Exception {
        String classPath = "com.f.chapter20.Car";
        //1.`static Class forName(String name)`：返回指定类名 `name` 的 `Class` 对象。
        //<?>表示不确定的Java类型
        Class<?> carClass = Class.forName(classPath);
        // 1.1 显示是哪个类的Class对象
        System.out.println(carClass);   //class com.f.chapter20.Car
        // 1.2 得到Class对象的运行类型 -> 即为 Class 类
        System.out.println(carClass.getClass());    //class java.lang.Class
        //2.getPackage()：得到Class对象所对应的类的包名
        System.out.println(carClass.getPackage());  //package com.f.chapter20
        //3.`getName()`：返回此 `Class` 对象所表示的实体（类、接口、数组类、基本类型等）名称。
        System.out.println(carClass.getName());     //com.f.chapter20.Car
        //4.`Object newlnstance()`：调用缺省构造函数，返回该 `Class` 对象的一个实例。
        Car car = (Car) carClass.newInstance();
        System.out.println(car);    //Car{brand='宝马', price=500000.0, color='red', speed=50.0}
        //5.getField：返回一个Field对象，它表示该类的相应字段(该字段需要为public)。
        Field brand = carClass.getField("brand");
        System.out.println(brand.get(car)); //宝马
        // 5.1 通过反射给属性赋值
        brand.set(car, "宾利");
        System.out.println(car);    //Car{brand='宾利', price=500000.0, color='red', speed=50.0}
        //6.getFields：获取所有 public 修饰的属性，包括本类及其父类的
        Field[] fields = carClass.getFields();
        for (Field field : fields) {
            System.out.print(field.getName() + " ");    //brand
        }
        System.out.println();
        //7.`Field[] getDeclaredFields()`：获取该类中所有的属性
        Field[] declaredFields = carClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.print(declaredField.getName() + " ");    //brand price color speed
        }
        System.out.println();
        //8.getMethods：获取所有 public 修饰的方法，包括本类及其父类的
        Method[] methods = carClass.getMethods();
        for (Method method : methods) {
            //除了 m1 和 toString 以外，其他是 Car 父类 Object 的 public 方法
            System.out.print(method.getName() + " ");   //toString m1 wait wait wait equals hashCode getClass notify notifyAll
        }
        System.out.println();
        //9.getDeclaredMethods：获取该类中所有的方法
        Method[] declaredMethods = carClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod.getName() + " ");   //m3 m2 m4 m1 toString
        }
        System.out.println();
        //10.`Constructor[] getConstructors()`：获取所有 `public` 修饰的构造器，只包括本类的。
        Constructor<?>[] constructors = carClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print(constructor + " ");    //public com.f.chapter20.Car()
        }
        System.out.println();
        //11.getDeclaredConstructors：获取该类中所有的构造器
        Constructor<?>[] declaredConstructors = carClass.getDeclaredConstructors();
        //private com.f.chapter20.Car(java.lang.String,double,java.lang.String)
        //com.f.chapter20.Car(java.lang.String,double)
        //protected com.f.chapter20.Car(java.lang.String)
        //public com.f.chapter20.Car()
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //12.`Class getSuperclass()`：返回该类的直接父类的 `Class` 对象。
        Class<?> superclass = carClass.getSuperclass();
        System.out.println(superclass); //class java.lang.Object
    }
}
