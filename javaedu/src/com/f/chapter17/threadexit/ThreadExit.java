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

        System.out.println("主线程休眠10秒...");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //main线程通知t线程退出
        t.setLoop(false);
    }
}

class T implements Runnable {

    private int cnt = 0;

    //设置一个控制变量
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程还在运行中... " + (++cnt));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}