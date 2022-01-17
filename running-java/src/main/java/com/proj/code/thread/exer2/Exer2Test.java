package com.proj.code.thread.exer2;

import java.util.ArrayList;

public class Exer2Test {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 30; i++) {
                    if (i != 0 && i % 10 == 0) {
                        try {
                            Thread.sleep(1000 + 10 * 1000);
                            System.out.println(Thread.currentThread().getName() + "已经跑完10米，休息10秒");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                long end = System.currentTimeMillis();
                arrayList.add(Thread.currentThread().getName() + "耗时：" + (end - start));
            }
        }, "兔子");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 1; i <= 30; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "已经跑完1米");
                        if (i % 10 == 0) {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName() + "已经跑完10米，休息1秒");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long end = System.currentTimeMillis();
                arrayList.add(Thread.currentThread().getName() + "耗时：" + (end - start));
            }
        }, "乌龟");


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(arrayList.get(0) + "获得第一名," + arrayList.get(1));

    }
}
