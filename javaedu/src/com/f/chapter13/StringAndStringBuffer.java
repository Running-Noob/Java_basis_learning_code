package com.f.chapter13;

/**
 * @author fzy
 * @date 2023/4/23 10:18
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {
        //String -> StringBuffer
        String str = new String("Tom");
        //��ʽ1��ʹ�� StringBuffer �Ĺ�����
        StringBuffer stringBuffer1 = new StringBuffer(str);
        //��ʽ2��ʹ�� StringBuffer �� append ����
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);

        //StringBuffer -> String
        StringBuffer stringBuffer3 = new StringBuffer("Jerry");
        //��ʽ1��ʹ�� StringBuffer �� toString ����
        String s1 = stringBuffer3.toString();
        //��ʽ2��ʹ�� String �Ĺ�����
        String s2 = new String(stringBuffer3);

        System.out.println(stringBuffer1);
        System.out.println(stringBuffer2);
        System.out.println(stringBuffer1 == stringBuffer2);     //false

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);                           //false
    }
}
