package com.proj.juc.ticket_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int num = 30;
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (num--) + "\t还剩" + num);
            }
        } finally {
            lock.unlock();
        }
    }
}
