package com.proj.code.thread.communicate;

class Waiter extends Thread {
    WorkBench wb;

    public Waiter(WorkBench wb) {
        this.wb = wb;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wb.take();
        }
    }
}
