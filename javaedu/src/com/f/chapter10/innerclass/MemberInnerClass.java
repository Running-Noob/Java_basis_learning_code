//package com.f.Chapter10.innerclass;
//
//public class MemberInnerClass {
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.f1();
//
//        //�ⲿ��������ʳ�Ա�ڲ���ĳ�Ա�����ַ�ʽ:
//        //��һ�ַ�ʽ��outer.new Inner()���൱�ڰ�new Inner()������outer��Ա
//        Outer.Inner inner01 = outer.new Inner();
//        Outer.Inner inner02 = new Outer().new Inner();
//
//        //�ڶ��ַ�ʽ�����ⲿ���У���дһ������������Inner����ʵ��
//        Outer.Inner inner03 = outer.getInnerInstance();
//
//        //ע�⣺��Ϊ�ڳ�Ա�ڲ����У�say ���������η��� private���������ⲿ�������У��޷����ø÷�����
//        //     �������ⲿ�����ǿ��Ե��ø÷����ģ��� f1 ������ʾ
//    }
//}
//
//class Outer {       //�ⲿ��
//    private int n1 = 10;
//    public String name = "����";
//
//    class Inner {   //��Ա�ڲ���
//        private void say() {
//            //����ֱ�ӷ����ⲿ������г�Ա������˽�е�
//            System.out.println("�ⲿ��Outer��n1 = " + Outer.this.n1);
//            System.out.println("�ⲿ��Outer��name = " + Outer.this.name);
//        }
//    }
//
//    public void f1(){
//        //ʹ�ó�Ա�ڲ��ࣺ������Ա�ڲ���Ķ���Ȼ��ʹ��
//        Inner inner = new Inner();
//        inner.say();
//    }
//
//    //�÷������س�Ա�ڲ����ʵ������
//    public Inner getInnerInstance(){
//        return new Inner();
//    }
//}
