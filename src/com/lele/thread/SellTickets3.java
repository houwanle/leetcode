package com.lele.thread;

/**
 * @author: lele
 * @date: 2023/6/3 12:00
 * @description: 多线程售票：synchronized锁代码块
 */

public class SellTickets3 {

    public static void main(String[] args) {
        SellTickets4 sellTickets4 = new SellTickets4();
        Thread t1 = new Thread(sellTickets4);
        Thread t2 = new Thread(sellTickets4);
        Thread t3 = new Thread(sellTickets4);

        t1.start();
        t2.start();
        t3.start();
    }
}

class SellTickets4 implements Runnable {
    private int num = 1000;
    private boolean loop = true;

    @Override
    public void run() {
        while(loop) {
            synchronized (this) {
                if (num > 0) {
                    num--;
                    System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余票数=" + num);
                } else {
                    loop = false;
                }
            }
        }
        System.out.println("票已售空");
    }
}
