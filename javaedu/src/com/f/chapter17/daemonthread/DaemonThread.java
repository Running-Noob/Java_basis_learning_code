package com.f.chapter17.daemonthread;

/**
 * @author fzy
 * @date 2023/7/2 22:10
 */
public class DaemonThread {
    public static void main(String[] args) {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //���ϣ����main�߳̽��������߳�myDaemonThread�����Զ��˳���
        // ��ֻ�轫���߳�myDaemonThread����Ϊ�ػ��̼߳��ɡ�
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("���߳�say hi... " + i);
        }
    }
}

class MyDaemonThread extends Thread {

    private int cnt = 1;

    @Override
    public void run() {
        while (true) {  //����ѭ��
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("���߳�say hello " + (cnt++));
        }
    }
}