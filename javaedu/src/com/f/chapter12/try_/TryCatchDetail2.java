package com.f.chapter12.try_;

public class TryCatchDetail2 {
    public static void main(String[] args) {
        try{
            String s = null;
            System.out.println(s.length());
            int i = 10 / 0;
        }catch(NullPointerException e){
            System.out.println("空指针异常...");
            System.out.println("错误原因为：" + e.getMessage());
        }catch(Exception e){
            System.out.println("其他异常...");
            System.out.println("错误原因为：" + e.getMessage());
        }finally{
            System.out.println("不论是否发生异常，一定会执行......");
        }
        System.out.println("程序继续执行...");
    }
}
