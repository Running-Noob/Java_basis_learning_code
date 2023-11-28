//package com.f.Chapter10.innerclass;
//
//public class AnonymousInnerClass {
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.method();
//    }
//}
//
//class Outer {
//    private int n1 = 100;
//
//    public void method() {
//        //基于接口的匿名内部类
//        //1. 需求：想使用 IA 接口，并创建对象
//        //2. 传统方式是写一个类，实现该接口，再创建这个类的对象
//        //3. 但需求是 Tiger 类只使用一次，后面不再使用
//        //4. 为了简化开发，可以使用匿名内部类
//        //5. tiger 的编译类型？ -> IA
//        //6. tiger 的运行类型？ -> Outer$1
//        /*
//            我们看底层，会发现系统分配有类名 Outer$1
//            class Outer$1 implements IA {
//                @Override
//                public void cry(){
//                    System.out.println("老虎叫唤...");
//                }
//            }
//        */
//        //7. jdk底层在创建匿名内部类 Outer$1 后，就立马创建了 Outer$1 实例，并且把地址返回给了 tiger 变量
//        //8. 匿名内部类只使用一次，就不再使用（注意这是对匿名内部类来说的，而不是对创建好的实例来说的）
//        IA tiger = new IA() {
//            @Override
//            public void cry() {
//                System.out.println("老虎叫唤...");
//            }
//        };
//        tiger.cry();
//        tiger.cry();
//        System.out.println("tiger的运行类型是：" + tiger.getClass());
//    }
//}
//
//interface IA {
//    void cry();
//}