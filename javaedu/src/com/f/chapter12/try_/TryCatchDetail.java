package com.f.chapter12.try_;

public class TryCatchDetail {
    public static void main(String[] args) {
        try {
            //用ctrl+alt+t快捷键快速添加try-catch块
            String s = "com";
            int num = Integer.parseInt(s);
            //如果异常发生了，则异常发生后面的代码不会执行，直接进入到catch块
            System.out.println("数字 = " + num);
        } catch (NumberFormatException e) {
            System.out.println("异常信息：" + e.getMessage());
        }
        System.out.println("程序继续执行...");
    }
}
