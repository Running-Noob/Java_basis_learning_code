//package com.f.Chapter10.innerclass;
//
//public class MemberInnerClass {
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.f1();
//
//        //外部其他类访问成员内部类的成员的两种方式:
//        //第一种方式：outer.new Inner()：相当于把new Inner()当作是outer成员
//        Outer.Inner inner01 = outer.new Inner();
//        Outer.Inner inner02 = new Outer().new Inner();
//
//        //第二种方式：在外部类中，编写一个方法，返回Inner对象实例
//        Outer.Inner inner03 = outer.getInnerInstance();
//
//        //注意：因为在成员内部类中，say 方法的修饰符是 private，所以在外部其他类中，无法调用该方法，
//        //     但是在外部类中是可以调用该方法的，如 f1 函数所示
//    }
//}
//
//class Outer {       //外部类
//    private int n1 = 10;
//    public String name = "张三";
//
//    class Inner {   //成员内部类
//        private void say() {
//            //可以直接访问外部类的所有成员，包括私有的
//            System.out.println("外部类Outer的n1 = " + Outer.this.n1);
//            System.out.println("外部类Outer的name = " + Outer.this.name);
//        }
//    }
//
//    public void f1(){
//        //使用成员内部类：创建成员内部类的对象，然后使用
//        Inner inner = new Inner();
//        inner.say();
//    }
//
//    //该方法返回成员内部类的实例对象
//    public Inner getInnerInstance(){
//        return new Inner();
//    }
//}
