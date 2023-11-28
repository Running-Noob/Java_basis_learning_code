package com.f.chapter10.final_;

public class FinalDetail {
    public static void main(String[] args) {
        System.out.println(AA.NUM);
    }
}

class AA{
    public static final int NUM = 10;
    static {
        System.out.println("Àà AA µÄ¾²Ì¬´úÂë¿é...");
    }
}
