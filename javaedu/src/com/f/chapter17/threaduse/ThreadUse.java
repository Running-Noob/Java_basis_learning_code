package com.f.chapter17.threaduse;

/**
 * @author fzy
 * @date 2023/7/1 20:44
 */
public class ThreadUse {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();	//start���������߳� -> ���ջ�ִ��cat��run����
        //��main�߳�����һ�����߳� Thread-0 �����߳�(main�߳�)���������������ִ��
        for (int i = 0; i < 60; i++) {
            System.out.println("���̣߳�" + Thread.currentThread().getName() + "�� i��ֵΪ" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/*
 * 1. ��һ����̳���Thread�࣬����Ϳ��Ե����߳�ʹ�á�
 * 2. ���ǻ���дrun������д���Լ���ҵ����롣
 * 3. Thread ��� run ������ʵ���� Runnable �ӿڵ� run ������
 * */
class Cat extends Thread {
    @Override
    public void run() { //��дrun������ʵ���Լ���ҵ���߼�
        int i = 1;
        //���߳�ÿ��1�룬�ڿ���̨���������...��
        while (true) {
            i++;
            System.out.println("����... �߳�����" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //���80�κ󣬾��˳�while��ͬʱ�߳�Ҳ���˳���
            if (i == 80) {
                break;
            }
        }
    }
}