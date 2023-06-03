package com.lele.thread;

/**
 * @author: lele
 * @date: 2023/6/3 11:42
 * @description: 多线程售票:volatile synchronized
 */

public class SellTickets {

    public static void main(String[] args) {
        SellTickets2 sellTickets2 = new SellTickets2();
        Thread t1 = new Thread(sellTickets2);
        Thread t2 = new Thread(sellTickets2);
        Thread t3 = new Thread(sellTickets2);

        t1.start();
        t2.start();
        t3.start();
    }
}

class SellTickets2 implements Runnable {
    //多线程下，保证可见性
    private volatile int num = 100;
    private volatile boolean loop = true;

    @Override
    public void run() {
        while(loop) {
            sell();
        }
    }

    //同步代码块，多线程下，保证该方法，同时只允许一个线程访问
    synchronized void sell() {
        if (num <= 0) {
            System.out.println("票已售空");
            loop = false;
            return;
        }
        num--;
        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余票数=" + num);
    }
}
