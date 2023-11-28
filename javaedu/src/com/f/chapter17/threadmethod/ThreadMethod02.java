package com.f.chapter17.threadmethod;

/**
 * @author fzy
 * @date 2023/7/2 21:40
 * 案例：main线程创建一个子线程，每隔1s输出hello，输出20次，
 *      主线程每隔1秒，输出hi，输出20次。
 *      要求：两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续输出。
 */
public class ThreadMethod02 {
    public static void main(String[] args) {
        PrintHello printHello = new PrintHello();
        Thread thread = new Thread(printHello);
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("hi " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 5) {   //当主线程输出5次后，就让子线程运行完毕，主线程再继续输出
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class PrintHello implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("hello " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}