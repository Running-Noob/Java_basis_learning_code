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
//        //������������ڲ���
//        //1. father01 �ı������ͣ� -> Father
//        //   father02 �ı������ͣ� -> Father
//        //2. father01 ���������ͣ� -> Outer$1
//        //   father02 ���������ͣ� -> Father
//        /*
//            ���ǿ��ײ㣬�ᷢ��ϵͳ���������� Outer$1
//            class Outer$1 extends Father {
//                @Override
//                public void test() {
//                    System.out.println("�����ڲ�����дFather���test����...");
//                }
//            }
//        */
//        //3. jdk�ײ��ڴ��������ڲ��� Outer$1 �󣬾��������� Outer$1 ʵ�������Ұѵ�ַ���ظ��� father01 ����
//        //4. �����ڲ���ֻʹ��һ�Σ��Ͳ���ʹ�ã�ע�����Ƕ������ڲ�����˵�ģ������ǶԴ����õ�ʵ����˵�ģ�
//        //5. ע�⣺("jack") ��������б�ᴫ�ݸ� Father ��Ĺ�����
//        Father father01 = new Father("jack") {
//            @Override
//            public void test() {
//                System.out.println("�����ڲ�����дFather���test����...");
//            }
//        };
//        System.out.println("father01�����������ǣ�" + father01.getClass());
//        //Father father02 = new Father("tom");
//        //System.out.println("father02�����������ǣ�" + father02.getClass());
//        father01.test();
//    }
//}
//
//class Father {
//    public Father(String name) {
//        System.out.println("Father��Ĺ����������յ�����name=" + name);
//    }
//
//    public void test() {
//        System.out.println("Father���test����...");
//    }
//}