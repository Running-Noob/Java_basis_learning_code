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
//        //���ڽӿڵ������ڲ���
//        //1. ������ʹ�� IA �ӿڣ�����������
//        //2. ��ͳ��ʽ��дһ���࣬ʵ�ָýӿڣ��ٴ��������Ķ���
//        //3. �������� Tiger ��ֻʹ��һ�Σ����治��ʹ��
//        //4. Ϊ�˼򻯿���������ʹ�������ڲ���
//        //5. tiger �ı������ͣ� -> IA
//        //6. tiger ���������ͣ� -> Outer$1
//        /*
//            ���ǿ��ײ㣬�ᷢ��ϵͳ���������� Outer$1
//            class Outer$1 implements IA {
//                @Override
//                public void cry(){
//                    System.out.println("�ϻ��л�...");
//                }
//            }
//        */
//        //7. jdk�ײ��ڴ��������ڲ��� Outer$1 �󣬾��������� Outer$1 ʵ�������Ұѵ�ַ���ظ��� tiger ����
//        //8. �����ڲ���ֻʹ��һ�Σ��Ͳ���ʹ�ã�ע�����Ƕ������ڲ�����˵�ģ������ǶԴ����õ�ʵ����˵�ģ�
//        IA tiger = new IA() {
//            @Override
//            public void cry() {
//                System.out.println("�ϻ��л�...");
//            }
//        };
//        tiger.cry();
//        tiger.cry();
//        System.out.println("tiger�����������ǣ�" + tiger.getClass());
//    }
//}
//
//interface IA {
//    void cry();
//}