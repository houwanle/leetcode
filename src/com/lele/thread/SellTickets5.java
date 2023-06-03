package com.lele.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lele
 * @date: 2023/6/3 12:08
 * @description: 多线程售票：ReentrantLock
 */

public class SellTickets5 extends Thread {

    public static void main(String[] args) {

        Resource resource = new Resource();

        new Thread(() -> {
            resource.desStock();
        }, "AA").start();

        new Thread(() -> {
            resource.desStock();
        }, "BB").start();
    }
}

class Resource {
    private int num = 1000;
    Lock lock = new ReentrantLock();
    boolean loop = true;

    public void desStock() {
        while(loop) {
            lock.lock();

            try {
                if (num > 0) {
                    num--;
                    System.out.println("窗口" + Thread.currentThread().getName()+"售出一张票，剩余票数" + num);
                } else {
                    loop = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
