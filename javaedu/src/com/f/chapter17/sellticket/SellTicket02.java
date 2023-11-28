package com.f.chapter17.sellticket;

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

class TicketWindow02 implements Runnable {
    private int ticketNum = 100;

    public int getTicketNum() {
        return ticketNum;
    }

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，还剩 " + (--ticketNum) + " 张票。");
        }
    }
}