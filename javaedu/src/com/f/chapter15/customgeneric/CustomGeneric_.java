package com.f.chapter15.customgeneric;

/**
 * @author fzy
 * @date 2023/6/29 19:54
 */
public class CustomGeneric_ {
    public static void main(String[] args) {
    }
}

//1. Tiger后面跟着泛型，所以Tiger为自定义泛型类
//2. T、R、M为泛型标识符，一般是单个大写字母
//3. 泛型标识符可以有多个
class Tiger<T, R, M> {
    String name;
    T t;
    R r;
    M m;

    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}
