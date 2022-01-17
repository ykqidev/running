package com.proj.code.thread.exer4;

public class PlayerTest {

    public static void main(String[] args) {

        Player p1 = new Player("兔子", 10 * 1000, 100);
        Player p2 = new Player("乌龟", 1000, 1000);

        p1.start();
        p2.start();


//        try {
//            p1.join();
//            p2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        while (true) {
            /*
             * 变量没加volatile的时候：
             * 注意：当main,很频繁不断地连续地去获取ended变量的值，获取很多次之后发现这个值一致不变，
             * 这个时候程序就会自我优化了，它就不去（主存）重写获取新的值，而是用原来的值（缓存）一直在判断
             */
            if (p1.isEnded() || p2.isEnded()) {
                break;
            }
        }

        if (p1.isEnded() && !p2.isEnded()) {
            System.out.println(p1.getName() + "已经赢");
        } else if (!p1.isEnded() && p2.isEnded()) {
            System.out.println(p2.getName() + "已经赢");
        } else {
            long p1RunTotalTime = p1.getRunTotalTime();
            long p2RunTotalTime = p2.getRunTotalTime();

            if (p1RunTotalTime < p2RunTotalTime) {
                System.out.println(p1.getName() + "已经赢");
            } else if (p1RunTotalTime > p2RunTotalTime) {
                System.out.println(p2.getName() + "已经赢");
            } else {
                System.out.println("两者已经赢");
            }
        }
    }

}

