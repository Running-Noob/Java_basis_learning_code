package com.f.chapter11.enum_;

public class EnumMethod {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        //1.toString��Enum���Ѿ���д���ˣ����ص��ǵ�ǰ�����������������д�÷��������ڷ��ض����������Ϣ
        System.out.println(autumn.toString());  //AUTUMN
        //2.name���õ���ǰö�ٳ��������ơ���������ʹ��toString
        System.out.println(autumn.name());  //AUTUMN
        //3.ordinal�������ö�ٶ���Ĵ���/��ţ���0��ʼ���
        System.out.println(autumn.ordinal());   //2
        //4.values������ö�����ö�ٶ������飬������ΪSeason[]
        for (Season season : Season.values())
            System.out.print(season + " ");  //SPRING SUMMER AUTUMN WINTER
        System.out.println();
        //5.valueOf�����ַ���ת����ö�ٶ���Ҫ���ַ�������Ϊ���еĳ������������쳣
        Season autumn2 = Season.valueOf("AUTUMN");
        System.out.println(autumn == autumn2);  //true
        //6.compareTo���Ƚ�����ö�ٳ����ı�ţ�������Ϊ��ǰ�ߵı�� - ���ߵı��
        System.out.println(Season.SUMMER.compareTo(Season.SUMMER)); //0
        System.out.println(Season.SUMMER.compareTo(Season.SPRING)); //1
        System.out.println(Season.SUMMER.compareTo(Season.WINTER)); //-2
    }
}

enum Season {
    SPRING("����"), SUMMER("����"), AUTUMN("����"), WINTER("����");
    private String name;

    private Season(String name) {
        this.name = name;
    }
}