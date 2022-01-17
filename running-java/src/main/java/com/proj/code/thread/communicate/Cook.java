package com.proj.code.thread.communicate;

class Cook extends Thread {
    WorkBench wb;

    public Cook(WorkBench wb) {
        this.wb = wb;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(29);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wb.put();
        }
    }
}
