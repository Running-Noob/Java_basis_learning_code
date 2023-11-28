package com.f.chapter17.threadexit;

/**
 * @author fzy
 * @date 2023/7/2 10:59
 */
public class ThreadExit {
    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();

        System.out.println("���߳�����10��...");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //main�߳�֪ͨt�߳��˳�
        t.setLoop(false);
    }
}

class T implements Runnable {

    private int cnt = 0;

    //����һ�����Ʊ���
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("�̻߳���������... " + (++cnt));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}