package com.f.chapter13;

/**
 * @author fzy
 * @date 2023/4/23 10:26
 */
public class Integer02 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);         //false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);         //true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);         //false
    }
}
