package com.f.chapter12.try_;

public class TryCatchDetail3 {
    public static void main(String[] args) {
        try{
            String s = null;
            System.out.println(s.length());
        }finally{
            System.out.println("不论是否发生异常，一定会执行......");
        }
        System.out.println("程序继续执行...");
    }
}
