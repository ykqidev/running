package com.proj.code.thread.exer3;

class Oop extends Thread {

    public Oop(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            PrintNumber.oop();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
