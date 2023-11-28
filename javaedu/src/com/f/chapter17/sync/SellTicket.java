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
        System.out.println("Ŀǰһ���� " + TicketWindow.getTicketNum() + " ��Ʊ��");
        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
    }
}

//ʹ�� synchronized ʵ���߳�ͬ��
class TicketWindow extends Thread {
    private static int ticketNum = 100;

    public static int getTicketNum() {
        return ticketNum;
    }

    public synchronized static void sell() {   //ͬ����������ͬһ��ʱ�̣�ֻ����һ���߳���ִ�� sell ����
        if (ticketNum <= 0) {
            System.out.println("��Ʊ����...");
            return;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("����" + Thread.currentThread().getName() + "�۳�һ��Ʊ����ʣ " + (--ticketNum) + " ��Ʊ��");
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
