//package com.f.Chapter10.innerclass;
//
//public class LocalInnerClass {
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.foo();
//        System.out.println("outer的地址为：" + outer);
//    }
//}
//
//class Outer {
//    private int n1 = 100;
//
//    public void foo() {
//        //局部内部类定义在外部类的局部位置上，比如方法中
//        final class Inner {
//            private int n1 = 200;
//
//            public void f1() {
//                //局部内部类可以直接访问外部类的所有成员，包含私有的
//                //Outer.this 本质就是外部类的对象，即哪个Outer类的对象调用了foo方法，那么这个Outer.this就是哪个对象
//                System.out.println("类Outer的私有成员n1的值为：" + Outer.this.n1);
//                System.out.println("Outer.this的地址为：" + Outer.this);
//                System.out.println("类Inner的私有成员n1的值为：" + n1);
//                System.out.println("类Inner的私有成员n1的值为：" + this.n1);
//            }
//        }
//        //外部类访问局部内部类的成员的方式是先创建对象，再访问（注意：必须在作用域内）
//        Inner inner = new Inner();
//        inner.f1();
//    }
//}
