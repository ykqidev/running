package com.proj.code.thread;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
//        FairLock r1 = new FairLock();
//        Thread t1 = new Thread(r1, "Thread_r1");
//        Thread t2 = new Thread(r1, "Thread_r2");
//        Thread t3 = new Thread(r1, "Thread_r3");
//
//        t1.start();
//        t2.start();
//        t3.start();
        ReenterLockCondition r1 = new ReenterLockCondition();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
        while (!lock.isHeldByCurrentThread()) {
            lock.lock();
            condition.signal();
            lock.unlock();
        }
    }


    static class FairLock implements Runnable {

        public static ReentrantLock fairLock = new ReentrantLock(true);

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//            while (true){
                try {
                    fairLock.lock();
                    System.out.println(Thread.currentThread().getName() + ": abc");
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fairLock.unlock();
                }
            }
        }
    }


    static class ReenterLockCondition implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ": abc");
                    Thread.sleep(200);
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();//
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class CallableThreadTest implements Callable<Integer> {

        public static void main(String[] args) {
            CallableThreadTest ctt = new CallableThreadTest();
            FutureTask<Integer> ft = new FutureTask<>(ctt);

            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
                if (i == 20) {
                    new Thread(ft, "有返回值的线程").start();
                }
            }

            try {
                System.out.println("子线程的返回值：" + ft.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Integer call() {

            int i = 0;
            for (; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);

            }
            return i;
        }
    }


    HashMap<String, Object> hashMap = new HashMap<>();

    @Test
    public void method01() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                hashMap.put("123", 123);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("是否存在：" + hashMap.get("123"));
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("是否存在：" + hashMap.get("123"));
            }
        }.start();
        System.out.println("是否存在：" + hashMap.get("123"));

    }

}
