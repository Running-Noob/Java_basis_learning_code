//package com.f.Chapter11;
//
//public class Enumeration01 {
//    public static void main(String[] args) {
//        System.out.println(Season.SPRING.getName());
//    }
//}
//
//class Season {
//    private String name;
//
//    //3.���Զ�������ڲ������̶��Ķ�����Ϊpublic
//    //4.ʹ�� `final`��`static` ��ͬ���Σ�����ֱ�����ã����Ҳ��ܱ��޸�
//    public static final Season SPRING = new Season("����");
//    public static final Season SUMMER = new Season("����");
//    public static final Season AUTUMN = new Season("����");
//    public static final Season WINTER = new Season("����");
//
//    //1.������˽�л�����ֹ��ֱ�� new ��������
//    private Season(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    //2.ȥ�� setXxx ��ط�������ֹ���Ա��޸�
//    //public void setName(String name) {
//    //    this.name = name;
//    //}
//}