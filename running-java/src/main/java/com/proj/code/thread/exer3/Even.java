package com.proj.code.thread.exer3;

class Even extends Thread {

    public Even(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            PrintNumber.even();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
