package com.proj.juc.consumer_demo;

/**
 * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 * <p>
 * 1    高聚低合前提下，线程操作资源类
 * 2   判断/干活/通知
 * 3   防止虚假唤醒
 * <p>
 * 知识小总结 = 多线程编程套路+while判断+新版写法
 */
public class ProdConsumerDemo {
    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(() -> {
                    for (int i1 = 0; i1 < 10; i1++) aircondition.increment();
                }, i + "").start();
            } else {
                new Thread(() -> {
                    for (int i1 = 0; i1 < 10; i1++) aircondition.decrement();
                }, i + "").start();
            }
        }
    }
}

