package com.proj.code.thread.exer1;

import java.util.Random;

/**
 * 丈夫和妻子共同用一个银行账号，丈夫负责存钱，妻子负责取钱
 */
public class AccountTest {

    public static void main(String[] args) {

        Account a = new Account();
        Random r = new Random();

        new Thread("丈夫") {
            @Override
            public void run() {
                while (true) {
                    a.save(r.nextInt(10000));
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("妻子") {
            @Override
            public void run() {
                while (true) {
                    a.withdraw(r.nextInt(10000));
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


    }
}

