package com.f.chapter12.try_;

public class TryCatchDetail3 {
    public static void main(String[] args) {
        try{
            String s = null;
            System.out.println(s.length());
        }finally{
            System.out.println("�����Ƿ����쳣��һ����ִ��......");
        }
        System.out.println("�������ִ��...");
    }
}
