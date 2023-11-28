package com.f.chapter10;

public class StaticMethod {
      static void main(String[] args) {
        Student stu1 = new Student("小明", 100);
        Student stu2 = new Student("小红", 200);
        Student.showTotalFee();     //用 类名.类方法名 调用类方法
    }
}

class Student {
    private String name;
    private static double fee = 0;

    public Student(String name, double fee) {
        this.name = name;
        Student.fee += fee;
    }

    public static void showTotalFee() {
        System.out.println("总学费有：" + Student.fee + " 元");
    }
}