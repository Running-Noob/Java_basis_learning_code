package com.f.chapter10;

public class TestMainParam {
    public static void main(String[] args) {
        //遍历 args
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数为：" + args[i]);
        }
    }
}