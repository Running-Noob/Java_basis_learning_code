package com.f.chapter17.sync;

/**
 * @author fzy
 * @date 2023/7/2 10:41
 */
public class SellTicket02 {
    public static void main(String[] args) {
        TicketWindow02 ticketWindow = new TicketWindow02();
        Thread thread1 = new Thread(ticketWindow);
        Thread thread2 = new Thread(ticketWindow);
        Thread thread3 = new Thread(ticketWindow);
        System.out.println("目前一共有 " + ticketWindow.getTicketNum() + " 张票。");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

//使用 synchronized 实现线程同步
class TicketWindow02 implements Runnable {
    private static int ticketNum = 100;

    public static int getTicketNum() {
        return ticketNum;
    }

    public synchronized void sell() {   //同步方法：在同一个时刻，只能有一个线程来执行 sell 方法。这时锁在this对象上
        /*
        //也可以用：
        //synchronized (对象) {	//得到对象的锁，才能操作同步代码
        //   //需要被同步的代码;
        //}
        //来实现线程同步

        synchronized (this) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，还剩 " + (--ticketNum) + " 张票。");
        }
        */

        if (ticketNum <= 0) {
            System.out.println("售票结束...");
            return;
        }


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，还剩 " + (--ticketNum) + " 张票。");
    }

    @Override
    public void run() {
        while (true) {
            sell();
            if (ticketNum <= 0) {
                break;
            }
        }
    }
}