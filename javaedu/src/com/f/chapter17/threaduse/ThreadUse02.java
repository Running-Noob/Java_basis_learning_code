package com.f.chapter17.threaduse;

/**
 * @author fzy
 * @date 2023/7/1 21:55
 * ͨ��ʵ�ֽӿ�Runnable�������߳�
 */
public class ThreadUse02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start();    //����Runnableû��start���������Բ�����ô��
        //ʹ�þ�̬����ģʽ
        Thread dogThread = new Thread(dog);
        dogThread.start();
    }
}

class Dog implements Runnable {

    int cnt = 0;

    @Override
    public void run() {
        while (true) {
            cnt++;
            System.out.println("С��������... " + "�߳�Ϊ��" + Thread.currentThread().getName() + " cntΪ��" + cnt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (cnt == 10) {
                break;
            }
        }
    }
}