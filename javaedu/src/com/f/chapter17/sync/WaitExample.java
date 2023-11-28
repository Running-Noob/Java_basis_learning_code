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
    static Object o1 = new Object();    //����Ϊstatic����֤����̵߳Ķ�����Ϊͬһ��
    static Object o2 = new Object();
    boolean flag;

    public SolveDeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) { //���󻥳������������ͬ������
                System.out.println(Thread.currentThread().getName() + " ����1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //����wait�����ͷ�o1������,ע��wait����һ������synchronized�е���
                try {
                    o1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " ����2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " ����3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " ����4");
                    //���ͷ�o1���������̻߳��ѣ�ʹ�����ִ��
                    o1.notify();
                }
            }
        }
    }
}