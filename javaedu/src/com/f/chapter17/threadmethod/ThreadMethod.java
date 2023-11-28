package com.f.chapter17.threadmethod;

/**
 * @author fzy
 * @date 2023/7/2 11:16
 */
public class ThreadMethod {
    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t);
        thread.setName("自定义的线程名：t");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(thread.getName() + "的优先级为：" + thread.getPriority());
        thread.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("main线程 - " + i);
        }
        //main线程对t线程发出中断
        thread.interrupt();
    }
}

class T implements Runnable {
    /*
     * 下面的run方法的逻辑为：
     * 1.先输出十次 Thread.currentThread().getName() + " - " + i
     * 2.然后线程开始休眠20秒
     * 3.如果线程被中断，就会退出休眠状态
     * 4.然后继续下一个循环，即重复1、2、3的步骤（这里就说明中断线程不是终止线程，因为线程被中断后又开始下一个循环）
     * */
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
            try {
                System.out.println("开始休眠 20 秒...");
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                //当该线程执行到一个 interrupt 方法时，就会 catch 一个异常，然后在 catch 块可以加入自己的业务代码
                //InterruptedException 是捕获到一个中断异常
                System.out.println(Thread.currentThread().getName() + "的休眠被 interrupt 了。");
            }
        }
    }
}