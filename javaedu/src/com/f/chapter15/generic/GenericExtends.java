package com.f.chapter15.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fzy
 * @date 2023/6/30 13:33
 */
public class GenericExtends {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //`List<?>`：表示支持任意泛型类型。
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //List<? extends AA>：表示支持 `AA` 类以及 `AA` 类的子类。
        // 即希望传入的list中的对象的类型为 `AA` 类或 `AA` 类的子类
        //printCollection2(list1);    //错误的
        //printCollection2(list2);    //错误的
        printCollection2(list3);
        printCollection2(list4);
        printCollection2(list5);

        //List<? super AA>：表示支持 `AA` 类以及 `AA` 类的父类，不限于直接父类。
        // 即希望传入的list中的对象的类型为 `AA` 类或 `AA` 类的父类，不限于直接父类
        printCollection3(list1);
        //printCollection3(list2);    //错误的
        printCollection3(list3);
        //printCollection3(list4);    //错误的
        //printCollection3(list5);    //错误的
    }

    //`<?>`：表示支持任意泛型类型。
    public static void printCollection1(List<?> c) {
        for (Object obj : c) {
            System.out.println(obj);
        }
    }

    //`<? extends A>`：表示支持 `A` 类以及 `A` 类的子类，规定了泛型的上限。
    public static void printCollection2(List<? extends AA> c) {
        for (AA aa : c) {
            System.out.println(aa);
        }
    }

    //`<? super A>` ：表示支持 `A` 类以及 `A` 类的父类，不限于直接父类，规定了泛型的下限。
    public static void printCollection3(List<? super AA> c) {
        for (Object obj : c) {
            System.out.println(obj);
        }
    }
}

class AA {

}

class BB extends AA {

}

class CC extends BB {

}