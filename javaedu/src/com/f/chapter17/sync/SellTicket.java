package com.f.chapter17.sync;

/**
 * @author fzy
 * @date 2023/7/2 10:30
 */
public class SellTicket {
    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow();
        TicketWindow ticketWindow2 = new TicketWindow();
        TicketWindow ticketWindow3 = new TicketWindow();
        System.out.println("目前一共有 " + TicketWindow.getTicketNum() + " 张票。");
        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
    }
}

//使用 synchronized 实现线程同步
class TicketWindow extends Thread {
    private static int ticketNum = 100;

    public static int getTicketNum() {
        return ticketNum;
    }

    public synchronized static void sell() {   //同步方法：在同一个时刻，只能有一个线程来执行 sell 方法
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
