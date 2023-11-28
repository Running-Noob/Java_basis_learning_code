package com.f.chapter17.threaduse;

/**
 * @author fzy
 * @date 2023/7/1 21:55
 * 通过实现接口Runnable来创建线程
 */
public class ThreadUse02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start();    //由于Runnable没有start方法，所以不能这么做
        //使用静态代理模式
        Thread dogThread = new Thread(dog);
        dogThread.start();
    }
}

class Dog implements Runnable {

    int cnt = 0;

    @Override
    public void run() {
        while (true) {
            cnt++;
            System.out.println("小狗汪汪叫... " + "线程为：" + Thread.currentThread().getName() + " cnt为：" + cnt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (cnt == 10) {
                break;
            }
        }
    }
}