package com.f.chapter13;

/**
 * @author fzy
 * @date 2023/4/24 10:21
 */
public class StringBufferMethod {
    public static void main(String[] args) {
        //����append
        StringBuffer s = new StringBuffer("hello");     //hello
        s.append(",");      //hello,
        s.append("world!").append(100).append(true).append(1.1);    //hello,world!100true1.1
        System.out.println(s);  //��� "hello,world!100true1.1"

        //ɾ��delete
        s.delete(12, 15);    //ɾ�� "100"
        System.out.println(s);  //��� "hello,world!true1.1"

        //�ģ�replace
        if (s.indexOf("true") != -1) {
            s.replace(s.indexOf("true"), s.indexOf("true") + "true".length(), "false");
            System.out.println(s);  //��� "hello,world!false1.1"
        }

        //�飺indexOf
        System.out.println(s.indexOf("false")); //��� 12

        //�壺insert
        s.insert(s.indexOf("false"), "true, ");
        System.out.println(s);      //��� "hello,world!true, false1.1"
    }
}