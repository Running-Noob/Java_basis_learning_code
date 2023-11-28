package com.f.chapter12.customexception_;

public class CustomException {
    public static void main(String[] args) {
        int age = 10;
        //要求年龄范围在18-120之间，否则抛出一个自定义异常
        if (!(age >= 18 && age <= 120)) {
            throw new AgeException("年龄需要设置在18-120之间...");
        }
        System.out.println("年龄范围正确...");
    }
}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}