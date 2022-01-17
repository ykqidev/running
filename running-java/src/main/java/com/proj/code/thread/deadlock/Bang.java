package com.proj.code.thread.deadlock;

class Bang extends Thread {
    private Object girl;
    private Object money;

    public Bang(Object girl, Object money) {
        this.girl = girl;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (money) {
            System.out.println("你给我钱，我放你女票");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (girl) {
                System.out.println("放人");
            }
        }
    }
}
