package com.f.chapter17.threadmethod;

/**
 * @author fzy
 * @date 2023/7/2 21:40
 * ������main�̴߳���һ�����̣߳�ÿ��1s���hello�����20�Σ�
 *      ���߳�ÿ��1�룬���hi�����20�Ρ�
 *      Ҫ�������߳�ͬʱִ�У������߳����5�κ󣬾������߳�������ϣ����߳��ټ��������
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
            if (i == 5) {   //�����߳����5�κ󣬾������߳�������ϣ����߳��ټ������
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