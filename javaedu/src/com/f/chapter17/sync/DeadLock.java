package com.f.chapter17.sync;

/**
 * @author fzy
 * @date 2023/7/4 14:14
 * ģ���߳�����
 */
public class DeadLock {
    public static void main(String[] args) {
        //��δ����γ�����
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(false);
        deadLockDemo1.start();
        deadLockDemo2.start();
        //������
        // 1.����deadLockDemo1����˶���o1�Ķ�������Ȼ��ʼ����1��
        // 2.����deadLockDemo2����˶���o2�Ķ�����
        // 3.��ʱdeadLockDemo1�������ߣ���deadLockDemo2ϣ���õ�����o1�Ķ�����
        // 4.���Ƕ���o1�Ķ�������deadLockDemo1�����deadLockDemo2�޷���������ִ��
        // 5.Ȼ��deadLockDemo1���߽�������deadLockDemo1Ҫ��������ִ�У���Ҫ�õ�����o2�Ķ�����
        // 6.���Ƕ���o2�Ķ�������deadLockDemo2�����deadLockDemo1�޷���������ִ��
        // 7.������һ���������deadLockDemo1Ҫ��������ִ�У���Ҫ�õ�����o2�Ķ��������������޷��ͷŶ���o1�Ķ�������
        //                  ��deadLockDemo2Ҫ��������ִ�У���Ҫ�õ�����o1�Ķ��������������޷��ͷŶ���o2�Ķ��������ɴ��γ�������
    }
}

class DeadLockDemo extends Thread{
    static Object o1 = new Object();    //����Ϊstatic����֤����̵߳Ķ�����Ϊͬһ��
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
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
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " ����2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " ����3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " ����4");
                }
            }
        }
    }
}