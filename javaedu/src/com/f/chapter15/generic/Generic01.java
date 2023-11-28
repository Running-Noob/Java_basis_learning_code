package com.f.chapter15.generic;

/**
 * @author fzy
 * @date 2023/6/24 19:39
 */
public class Generic01 {
    public static void main(String[] args) {
        //传入 String 类型给 E，则 Person 类中所有为 E 的地方都可以看作被 String 替代
        Person<String> p1 = new Person<String>("hello");
        p1.show();  //class java.lang.String

        //传入 Integer 类型给 E，则 Person 类中所有为 E 的地方都可以看作被 Integer 替代
        Person<Integer> p2 = new Person<Integer>(10);
        p2.show();  //class java.lang.Integer
    }
}

class Person<E> {   //这里的 E 就是泛型
    //用 E 表示 s 的数据类型，该数据类型是在定义 Person 对象的时候指定的，
    // 即在编译期间，就可以确定 E 是什么类型
    E s;

    public Person(E s) {    //E 也可以是参数类型
        this.s = s;
    }

    public E getS() {   //E 也可以是返回类型
        return s;
    }

    public void show(){
        System.out.println(s.getClass());
    }
}
