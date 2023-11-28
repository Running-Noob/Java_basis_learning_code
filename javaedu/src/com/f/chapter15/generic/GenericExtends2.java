package com.f.chapter15.generic;

import java.util.List;

/**
 * @author fzy
 * @date 2023/6/30 14:43
 */
public class GenericExtends2 {
    public static void main(String[] args) {
        P<String> p1 = new P<>();   //T会被替换成String
        P<Integer> p2 = new P<>();  //T会被替换成Integer
        P<List> p3 = new P<List>(); //T会被替换成List
        /*
         * 下面的语句 p1.set(p2) 可以这么看：传入的参数为p2，而p2使用的泛型类型为Integer，
         *   对于P类的set方法，若把 <> 遮掉，则可以看出，要传入的是一个P类的对象，
         *   此时再看 <> 内部，表示传入的这个P类的对象，其使用的泛型类型应为List或其子类，
         *   而p2使用的泛型类型为Integer，不满足 <> 内的要求，所以下面的语句会报错。
         * */
        //p1.set(p2); //错误的
        p1.set(p3); //正确的
    }
}

class P<T> {
    private T t;

    public T getT() {
        return t;
    }

    //通配符
    //设置指定类型的范围，超过范围就会报错
    //extends : 指定范围必须是其(这里是List)子类
    public void set(P<? extends List> p) {
        return;
    }

    //super : 指定类型必须是其(这里是List)父类
    public void setSuper(P<? super List> p) {
        return;
    }
}