package com.proj.code.thread.exer4;

class Player extends Thread {

    private long sleep;
    private long perSecondMi;
    private long runTotalTime;
    private volatile boolean ended;

    public Player(String name, long sleep, long perSecondMi) {
        super(name);
        this.sleep = sleep;
        this.perSecondMi = perSecondMi;
    }

    public boolean isEnded() {
        return ended;
    }

    public long getRunTotalTime() {
        return runTotalTime;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(perSecondMi);
                System.out.println(getName() + "跑了" + (i + 1) + "米");
                if (i == 10 || i == 20) {
                    System.out.println(getName() + "在休息中...");
                    System.out.println(getName() + "休息" + sleep + "毫秒");
                    Thread.sleep(sleep);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ended = true;
        runTotalTime = System.currentTimeMillis() - start;
        System.out.println(getName() + "已经跑完");

    }
}
