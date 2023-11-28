package com.f.chapter17.sync;

/**
 * @author fzy
 * @date 2023/7/4 14:14
 * 模拟线程死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        //这段代码形成死锁
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(false);
        deadLockDemo1.start();
        deadLockDemo2.start();
        //分析：
        // 1.首先deadLockDemo1获得了对象o1的对象锁，然后开始休眠1秒
        // 2.接着deadLockDemo2获得了对象o2的对象锁
        // 3.此时deadLockDemo1仍在休眠，而deadLockDemo2希望得到对象o1的对象锁
        // 4.但是对象o1的对象锁在deadLockDemo1，因此deadLockDemo2无法继续向下执行
        // 5.然后deadLockDemo1休眠结束，若deadLockDemo1要继续向下执行，就要得到对象o2的对象锁
        // 6.但是对象o2的对象锁在deadLockDemo2，因此deadLockDemo1无法继续向下执行
        // 7.这就造成一个情况：若deadLockDemo1要继续向下执行，就要得到对象o2的对象锁，否则其无法释放对象o1的对象锁，
        //                  若deadLockDemo2要继续向下执行，就要得到对象o1的对象锁，否则其无法释放对象o2的对象锁，由此形成死锁。
    }
}

class DeadLockDemo extends Thread{
    static Object o1 = new Object();    //设置为static，保证多个线程的对象锁为同一个
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
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
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " 进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入4");
                }
            }
        }
    }
}