//package com.f.Chapter11;
//
//public class Enumeration01 {
//    public static void main(String[] args) {
//        System.out.println(Season.SPRING.getName());
//    }
//}
//
//class Season {
//    private String name;
//
//    //3.在自定义类的内部创建固定的对象，且为public
//    //4.使用 `final`、`static` 共同修饰，可以直接引用，而且不能被修改
//    public static final Season SPRING = new Season("春天");
//    public static final Season SUMMER = new Season("夏天");
//    public static final Season AUTUMN = new Season("秋天");
//    public static final Season WINTER = new Season("冬天");
//
//    //1.构造器私有化，防止被直接 new 创建对象
//    private Season(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    //2.去除 setXxx 相关方法，防止属性被修改
//    //public void setName(String name) {
//    //    this.name = name;
//    //}
//}