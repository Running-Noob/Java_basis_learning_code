//package com.f.Chapter10.innerclass;
//
//public class AnonymousInnerClassExercise {
//    public static void main(String[] args) {
//        //��������ʵ��ֱ�Ӵ��ݣ��������Ч��
//        f1(new IA(){
//            @Override
//            public void show() {
//                System.out.println("�����ڲ���� show ����...");
//            }
//        });
//    }
//
//    //��̬�������β��ǽӿ����� IA
//    public static void f1(IA ia) {
//        ia.show();
//    }
//}
//
//interface IA {
//    void show();
//}