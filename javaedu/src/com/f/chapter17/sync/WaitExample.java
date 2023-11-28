package com.f.chapter17.sync;

/**
 * @author fzy
 * @date 2023/7/4 21:20
 */
public class WaitExample {
    public static void main(String[] args) {
        SolveDeadLockDemo solveDeadLockDemo1 = new SolveDeadLockDemo(true);
        SolveDeadLockDemo solveDeadLockDemo2 = new SolveDeadLockDemo(false);
        solveDeadLockDemo1.start();
        solveDeadLockDemo2.start();
    }
}

class SolveDeadLockDemo extends Thread {
    static Object o1 = new Object();    //设置为static，保证多个线程的对象锁为同一个
    static Object o2 = new Object();
    boolean flag;

    public SolveDeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) { //对象互斥锁，下面就是同步代码
                System.out.println(Thread.currentThread().getName() + " 进入1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //调用wait方法释放o1对象锁,注意wait方法一定是在synchronized中调用
                try {
                    o1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " 进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入4");
                    //将释放o1对象锁的线程唤醒，使其继续执行
                    o1.notify();
                }
            }
        }
    }
}