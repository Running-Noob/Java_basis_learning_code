package com.f.chapter13;

/**
 * @author fzy
 * @date 2023/4/24 10:21
 */
public class StringBufferMethod {
    public static void main(String[] args) {
        //增：append
        StringBuffer s = new StringBuffer("hello");     //hello
        s.append(",");      //hello,
        s.append("world!").append(100).append(true).append(1.1);    //hello,world!100true1.1
        System.out.println(s);  //输出 "hello,world!100true1.1"

        //删：delete
        s.delete(12, 15);    //删除 "100"
        System.out.println(s);  //输出 "hello,world!true1.1"

        //改：replace
        if (s.indexOf("true") != -1) {
            s.replace(s.indexOf("true"), s.indexOf("true") + "true".length(), "false");
            System.out.println(s);  //输出 "hello,world!false1.1"
        }

        //查：indexOf
        System.out.println(s.indexOf("false")); //输出 12

        //插：insert
        s.insert(s.indexOf("false"), "true, ");
        System.out.println(s);      //输出 "hello,world!true, false1.1"
    }
}