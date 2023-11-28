package com.f.chapter12.throws_;

import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {

    }

    public void f1() throws NullPointerException, ArithmeticException, NumberFormatException {

    }
}

class A {
    public void f1() throws Exception{
    }
}

class B extends A {
    @Override
    public void f1() throws FileNotFoundException {

    }
}