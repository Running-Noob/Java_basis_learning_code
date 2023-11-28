package com.f.chapter17.threaduse;

/**
 * @author fzy
 * @date 2023/7/1 20:44
 */
public class ThreadUse {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();	//start用于启动线程 -> 最终会执行cat的run方法
        //当main线程启动一个子线程 Thread-0 后，主线程(main线程)不会阻塞，会继续执行
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程：" + Thread.currentThread().getName() + "。 i的值为" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/*
 * 1. 当一个类继承了Thread类，该类就可以当作线程使用。
 * 2. 我们会重写run方法，写上自己的业务代码。
 * 3. Thread 类的 run 方法是实现了 Runnable 接口的 run 方法。
 * */
class Cat extends Thread {
    @Override
    public void run() { //重写run方法，实现自己的业务逻辑
        int i = 1;
        //该线程每隔1秒，在控制台输出“喵喵...”
        while (true) {
            i++;
            System.out.println("喵喵... 线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //输出80次后，就退出while，同时线程也就退出了
            if (i == 80) {
                break;
            }
        }
    }
}