package com.proj.code.thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {

        private String soldier;

        private final CyclicBarrier cyclic;

        public Soldier(String soldier, CyclicBarrier cyclic) {
            this.soldier = soldier;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {

            try {
                cyclic.await();
                doWork();
                cyclic.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(soldier + ":任务完成");
        }
    }


    public static class BarrierRun implements Runnable {

        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：[士兵" + N + "个，任务完成！]");
            } else {
                System.out.println("司令：[士兵" + N + "个，集合完毕！]");
                flag = true;
            }
        }
    }


    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[10];
        boolean flag = false;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合队伍");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵 " + i + " 报道！");
            allSoldier[i] = new Thread(new Soldier("士兵" + i, cyclicBarrier));
            allSoldier[i].start();

        }
    }

    @Test
    public void Test() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);

        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
