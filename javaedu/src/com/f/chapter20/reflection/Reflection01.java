package com.f.chapter20.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/7/24 16:58
 * 反射相关类的使用
 */
public class Reflection01 {
    public static void main(String[] args) throws Exception {
        //1.使用 Properties 类, 从配置文件中读取类的相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\1\\Code Project\\Java project\\file\\cat.properties"));
        String classPath = properties.getProperty("class");
        String method = properties.getProperty("method");
        String field = properties.getProperty("field");
        //2.使用Java反射机制
        // 2.1 java.lang.Class的使用
        Class catClass = Class.forName(classPath);  //根据配置文件得到Cat类的Class对象
        Object o = catClass.newInstance();      //根据该Class对象创建Cat类的对象
        // 2.2 java.lang.reflect.Method的使用
        Method catMethod = catClass.getMethod(method);  //根据配置文件得到Cat类的相应方法
        //传统方法: 对象.方法(); 反射机制: 方法.invoke(对象)
        catMethod.invoke(o);        //通过invoke函数调用该对象的该相应方法
        // 2.3 java.lang.reflect.Field的使用
        //gatField不能得到类的私有成员变量
        Field nameField = catClass.getField(field);     //根据配置文件得到Cat类的相应字段
        //传统方法: 对象.成员变量; 反射机制: 成员变量.get(对象)
        System.out.println(nameField.get(o));   //通过get函数得到该对象的该相应成员变量
        // 2.4 java.lang.reflect.Constructor的使用
        Constructor constructor1 = catClass.getConstructor();    //()中可以指定构造器的参数类型
        System.out.println(constructor1);   //public com.f.chapter20.Cat()
        Constructor constructor2 = catClass.getConstructor(String.class);   //这里传入的是String类的Class对象
        System.out.println(constructor2);   //public com.f.chapter20.Cat(java.lang.String)
    }
}
