package com.proj.code.thread.communicate;

/**
 * 工作台：出菜的窗口的平台
 */
class WorkBench {

    private static final int MAX_VALUE = 10;
    private int num;

    public synchronized void put() {
        if (num >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println("厨师又炒了一份菜，剩余：" + num);
        notify();
    }

    public synchronized void take() {
        if (num == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println("服务员又取走了一份菜，剩余：" + num);
        this.notify();
    }


    //----------------------第二种情况
    public synchronized void put2() {
        while (num >= MAX_VALUE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println("厨师又炒了一份菜，剩余：" + num);

        notifyAll();
    }


    public synchronized void take2() {
        while (num <= 0) { // 如果用if 会导致出现负数
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println("服务员又取走了一份菜，剩余：" + num);
//        notify();  // 如果用notify 有可能会唤醒自己 最后导致卡死
        this.notifyAll();
    }
}
