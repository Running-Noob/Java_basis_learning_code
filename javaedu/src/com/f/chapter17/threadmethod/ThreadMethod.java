package com.f.chapter17.threadmethod;

/**
 * @author fzy
 * @date 2023/7/2 11:16
 */
public class ThreadMethod {
    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t);
        thread.setName("�Զ�����߳�����t");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(thread.getName() + "�����ȼ�Ϊ��" + thread.getPriority());
        thread.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("main�߳� - " + i);
        }
        //main�̶߳�t�̷߳����ж�
        thread.interrupt();
    }
}

class T implements Runnable {
    /*
     * �����run�������߼�Ϊ��
     * 1.�����ʮ�� Thread.currentThread().getName() + " - " + i
     * 2.Ȼ���߳̿�ʼ����20��
     * 3.����̱߳��жϣ��ͻ��˳�����״̬
     * 4.Ȼ�������һ��ѭ�������ظ�1��2��3�Ĳ��裨�����˵���ж��̲߳�����ֹ�̣߳���Ϊ�̱߳��жϺ��ֿ�ʼ��һ��ѭ����
     * */
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
            try {
                System.out.println("��ʼ���� 20 ��...");
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                //�����߳�ִ�е�һ�� interrupt ����ʱ���ͻ� catch һ���쳣��Ȼ���� catch ����Լ����Լ���ҵ�����
                //InterruptedException �ǲ���һ���ж��쳣
                System.out.println(Thread.currentThread().getName() + "�����߱� interrupt �ˡ�");
            }
        }
    }
}