//package com.f.Chapter11.enum_;
//
//public class Enumeration02 {
//    public static void main(String[] args) {
//        System.out.println(Season.SPRING.getName());
//    }
//}
//
//enum Season {
//    //1.ʹ�ùؼ��� enum ��� class
//    //2.public static final Season SPRING = new Season("����");
//    //  ֱ��ʹ��SPRING("����")���  -->  ������(ʵ���б�)
//    //3.����ж����������ʹ�� ��,�� �������
//    //4.���ʹ�� enum ʵ��ö�٣���Ҫ�Ѷ���ĳ�������д����ǰ��
//    SPRING("����"), SUMMER("����"), AUTUMN("����"), WINTER("����");
//    private String name;
//
//    private Season(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//}