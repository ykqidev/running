package com.proj.code.thread.exer1;

class Account {
    private double balance;

    public synchronized void save(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("参数异常");
        }
        balance += money;
        System.out.println("丈夫存钱 ：" + money + "，余额：" + balance);
        this.notify();
    }

    public synchronized void withdraw(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("参数异常");
        }
        while (balance < money) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= money;
        System.out.println("妻子取钱 ：" + money + "，余额：" + balance);
    }
}
