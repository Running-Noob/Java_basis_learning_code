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
        System.out.println("Ŀǰһ���� " + ticketWindow.getTicketNum() + " ��Ʊ��");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

//ʹ�� synchronized ʵ���߳�ͬ��
class TicketWindow02 implements Runnable {
    private static int ticketNum = 100;

    public static int getTicketNum() {
        return ticketNum;
    }

    public synchronized void sell() {   //ͬ����������ͬһ��ʱ�̣�ֻ����һ���߳���ִ�� sell ��������ʱ����this������
        /*
        //Ҳ�����ã�
        //synchronized (����) {	//�õ�������������ܲ���ͬ������
        //   //��Ҫ��ͬ���Ĵ���;
        //}
        //��ʵ���߳�ͬ��

        synchronized (this) {
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
        */

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