//package com.f.Chapter10.innerclass;
//
//public class AnonymousInnerClass_ {
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
//        //基于类的匿名内部类
//        //1. father01 的编译类型？ -> Father
//        //   father02 的编译类型？ -> Father
//        //2. father01 的运行类型？ -> Outer$1
//        //   father02 的运行类型？ -> Father
//        /*
//            我们看底层，会发现系统分配有类名 Outer$1
//            class Outer$1 extends Father {
//                @Override
//                public void test() {
//                    System.out.println("匿名内部类重写Father类的test方法...");
//                }
//            }
//        */
//        //3. jdk底层在创建匿名内部类 Outer$1 后，就立马创建了 Outer$1 实例，并且把地址返回给了 father01 变量
//        //4. 匿名内部类只使用一次，就不再使用（注意这是对匿名内部类来说的，而不是对创建好的实例来说的）
//        //5. 注意：("jack") 这个参数列表会传递给 Father 类的构造器
//        Father father01 = new Father("jack") {
//            @Override
//            public void test() {
//                System.out.println("匿名内部类重写Father类的test方法...");
//            }
//        };
//        System.out.println("father01的运行类型是：" + father01.getClass());
//        //Father father02 = new Father("tom");
//        //System.out.println("father02的运行类型是：" + father02.getClass());
//        father01.test();
//    }
//}
//
//class Father {
//    public Father(String name) {
//        System.out.println("Father类的构造器，接收到参数name=" + name);
//    }
//
//    public void test() {
//        System.out.println("Father类的test方法...");
//    }
//}