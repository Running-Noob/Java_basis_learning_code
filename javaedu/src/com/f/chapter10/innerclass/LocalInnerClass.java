//package com.f.Chapter10.innerclass;
//
//public class LocalInnerClass {
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.foo();
//        System.out.println("outer�ĵ�ַΪ��" + outer);
//    }
//}
//
//class Outer {
//    private int n1 = 100;
//
//    public void foo() {
//        //�ֲ��ڲ��ඨ�����ⲿ��ľֲ�λ���ϣ����緽����
//        final class Inner {
//            private int n1 = 200;
//
//            public void f1() {
//                //�ֲ��ڲ������ֱ�ӷ����ⲿ������г�Ա������˽�е�
//                //Outer.this ���ʾ����ⲿ��Ķ��󣬼��ĸ�Outer��Ķ��������foo��������ô���Outer.this�����ĸ�����
//                System.out.println("��Outer��˽�г�Աn1��ֵΪ��" + Outer.this.n1);
//                System.out.println("Outer.this�ĵ�ַΪ��" + Outer.this);
//                System.out.println("��Inner��˽�г�Աn1��ֵΪ��" + n1);
//                System.out.println("��Inner��˽�г�Աn1��ֵΪ��" + this.n1);
//            }
//        }
//        //�ⲿ����ʾֲ��ڲ���ĳ�Ա�ķ�ʽ���ȴ��������ٷ��ʣ�ע�⣺�������������ڣ�
//        Inner inner = new Inner();
//        inner.f1();
//    }
//}
