package com.f.chapter17.daemonthread;

/**
 * @author fzy
 * @date 2023/7/2 22:10
 */
public class DaemonThread {
    public static void main(String[] args) {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果希望当main线程结束后，子线程myDaemonThread可以自动退出。
        // 则只需将子线程myDaemonThread设置为守护线程即可。
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("主线程say hi... " + i);
        }
    }
}

class MyDaemonThread extends Thread {

    private int cnt = 1;

    @Override
    public void run() {
        while (true) {  //无限循环
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程say hello " + (cnt++));
        }
    }
}