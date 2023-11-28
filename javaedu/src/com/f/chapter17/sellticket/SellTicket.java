package com.f.chapter17.sellticket;

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

class TicketWindow extends Thread {
    private static int ticketNum = 100;

    public static int getTicketNum() {
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

            System.out.println("售出一张票，还剩 " + (--ticketNum) + " 张票。");
        }
    }
}
