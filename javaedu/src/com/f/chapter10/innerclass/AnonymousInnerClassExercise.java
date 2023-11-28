//package com.f.Chapter10.innerclass;
//
//public class AnonymousInnerClassExercise {
//    public static void main(String[] args) {
//        //匿名当作实参直接传递，代码简洁高效。
//        f1(new IA(){
//            @Override
//            public void show() {
//                System.out.println("匿名内部类的 show 方法...");
//            }
//        });
//    }
//
//    //静态方法，形参是接口类型 IA
//    public static void f1(IA ia) {
//        ia.show();
//    }
//}
//
//interface IA {
//    void show();
//}