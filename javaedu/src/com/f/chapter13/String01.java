package com.f.chapter13;

public class String01 {
    public static void main(String[] args) {
        //包装类(以Integer为例)和 String 的相互转换
        //Integer -> String
        Integer i1 = 100;           //自动装箱
        String s1 = i1 + "";        //方式1
        String s2 = i1.toString();  //方式2
        String s3 = String.valueOf(i1); //方式3
        //String -> Integer
        Integer i2 = Integer.parseInt(s1);  //方式1 parseInt方法返回的是 int 类型数据，所以这里还用到了自动装箱，将 int 装箱为 Integer
        Integer i3 = Integer.valueOf(s1);   //方式2
    }
}
