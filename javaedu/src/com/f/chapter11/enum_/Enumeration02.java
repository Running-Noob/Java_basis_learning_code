//package com.f.Chapter11.enum_;
//
//public class Enumeration02 {
//    public static void main(String[] args) {
//        System.out.println(Season.SPRING.getName());
//    }
//}
//
//enum Season {
//    //1.使用关键字 enum 替代 class
//    //2.public static final Season SPRING = new Season("春天");
//    //  直接使用SPRING("春天")替代  -->  常量名(实参列表)
//    //3.如果有多个常量对象，使用 ”,“ 间隔即可
//    //4.如果使用 enum 实现枚举，则要把定义的常量对象写在最前面
//    SPRING("春天"), SUMMER("夏天"), AUTUMN("秋天"), WINTER("冬天");
//    private String name;
//
//    private Season(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//}