package com.f.chapter13;

/**
 * @author fzy
 * @date 2023/4/23 10:18
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {
        //String -> StringBuffer
        String str = new String("Tom");
        //方式1：使用 StringBuffer 的构造器
        StringBuffer stringBuffer1 = new StringBuffer(str);
        //方式2：使用 StringBuffer 的 append 方法
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);

        //StringBuffer -> String
        StringBuffer stringBuffer3 = new StringBuffer("Jerry");
        //方式1：使用 StringBuffer 的 toString 方法
        String s1 = stringBuffer3.toString();
        //方式2：使用 String 的构造器
        String s2 = new String(stringBuffer3);

        System.out.println(stringBuffer1);
        System.out.println(stringBuffer2);
        System.out.println(stringBuffer1 == stringBuffer2);     //false

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);                           //false
    }
}
