package com.f.chapter17.threadstate;

/**
 * @author fzy
 * @date 2023/7/3 20:34
 */
public class ThreadState {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.getName() + " 的状态为：" + t.getState());
        t.start();

        while (t.getState() != Thread.State.TERMINATED) {
            System.out.println(t.getName() + " 的状态为：" + t.getState());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(t.getName() + " 的状态为：" + t.getState());

    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
