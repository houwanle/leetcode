package com.lele.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lele
 * @date: 2023/6/3 12:22
 * @description:
 */

public class SellTickets6 extends Thread{

    public static void main(String[] args) {
        Resource1 resource1 = new Resource1();

        new Thread(() -> {
            resource1.sell();
        }, "AA").start();

        new Thread(() -> {
            resource1.sell();
        }, "BB").start();

    }
}

class Resource1 {
    private AtomicInteger at = new AtomicInteger(1000);
    boolean loop = true;

    public int desStock() {
        return at.decrementAndGet();
    }

    public void sell() {
        while (loop) {
            synchronized (this) {
                int i = desStock();
                if (i > 0) {
                    System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余票数=" + i);
                } else {
                    loop = false;
                }
            }
        }
    }
}
