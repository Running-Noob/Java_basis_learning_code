package com.f.chapter12.exception_;

public class NumberFormatException {
    public static void main(String[] args) {
        String s1, s2;
        s1 = "1234";
        s2 = "comf";
        System.out.println(Integer.parseInt(s1));       //Êä³ö1234
        //System.out.println(Integer.parseInt(s2));       //Òì³££ºNumberFormatException
    }
}
