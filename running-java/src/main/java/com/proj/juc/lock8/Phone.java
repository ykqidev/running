package com.proj.juc.lock8;

import java.util.concurrent.TimeUnit;

class Phone {
    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("========> send email ");
    }

    public static synchronized void sendSMS() {
        System.out.println("==========> send message");
    }

    public void sendHello() {
        System.out.println("============> send hello");
    }
}
