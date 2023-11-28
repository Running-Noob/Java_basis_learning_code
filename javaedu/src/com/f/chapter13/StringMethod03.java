package com.f.chapter13;

public class StringMethod03 {
    public static void main(String[] args) {
        String s = new String("john");
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(s)));
        s = new String("tom");
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(s)));
    }
}
