package com.proj.code.thread.deadlock;

class Boy extends Thread {
    private Object girl;
    private Object money;

    public Boy(Object girl, Object money) {
        this.girl = girl;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (girl) {
            System.out.println("我给你钱，你放我女票");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (money) {
                System.out.println("给你钱");
            }
        }
    }
}
