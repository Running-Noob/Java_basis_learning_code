package com.f.chapter13;

public class String02 {
    public static void main(String[] args) {
        String s1 = new String("1") + new String("1");    //常量池中生成”1“，s1指向堆中的对象，堆中对象的value内容为”11“
        s1.intern();        //常量池中没有”11“，所以将s1的地址添加到常量池中
        String s2 = "11";   //因为常量池中存在”11“的引用s1，所以s2指向常量池中s1的地址
        System.out.println(s1 == s2);   //返回true
        String s3 = s2 + "22";
    }
}
