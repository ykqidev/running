package com.proj.code.thread.exer3;

class PrintNumber {
    private static int num;
    private static final Object lock = new Object();

    // 不能把synchronized写到方法上 因为方法上的锁是锁类对象 而里面是锁lock
    public static void oop() {
        synchronized (lock) {
            if (num % 2 == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                lock.notify();
            }
        }
    }

    public static void even() {
        synchronized (lock) {
            if (num % 2 != 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": === " + num);
                num++;
                lock.notify();
            }
        }
    }

//    public synchronized static void even() {
//        if (num % 2 != 0) {
//            try {
//                PrintNumber.class.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println(Thread.currentThread().getName() + ": === " + num);
//            num++;
//            PrintNumber.class.notify();
//        }
//    }
}
