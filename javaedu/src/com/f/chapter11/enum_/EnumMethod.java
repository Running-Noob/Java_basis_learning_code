package com.f.chapter11.enum_;

public class EnumMethod {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        //1.toString：Enum类已经重写过了，返回的是当前对象名，子类可以重写该方法，用于返回对象的属性信息
        System.out.println(autumn.toString());  //AUTUMN
        //2.name：得到当前枚举常量的名称。建议优先使用toString
        System.out.println(autumn.name());  //AUTUMN
        //3.ordinal：输出该枚举对象的次序/编号，从0开始编号
        System.out.println(autumn.ordinal());   //2
        //4.values：返回枚举类的枚举对象数组，如这里为Season[]
        for (Season season : Season.values())
            System.out.print(season + " ");  //SPRING SUMMER AUTUMN WINTER
        System.out.println();
        //5.valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        Season autumn2 = Season.valueOf("AUTUMN");
        System.out.println(autumn == autumn2);  //true
        //6.compareTo：比较两个枚举常量的编号，输出结果为：前者的编号 - 后者的编号
        System.out.println(Season.SUMMER.compareTo(Season.SUMMER)); //0
        System.out.println(Season.SUMMER.compareTo(Season.SPRING)); //1
        System.out.println(Season.SUMMER.compareTo(Season.WINTER)); //-2
    }
}

enum Season {
    SPRING("春天"), SUMMER("夏天"), AUTUMN("秋天"), WINTER("冬天");
    private String name;

    private Season(String name) {
        this.name = name;
    }
}