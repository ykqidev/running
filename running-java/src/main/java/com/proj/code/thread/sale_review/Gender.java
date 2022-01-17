package com.proj.code.thread.sale_review;

enum Gender implements Runnable,Walkable{
    // 分别实现接口
    MAN{
        @Override
        public void walk() {
            System.out.println("大步流星");
        }
    },WOMAN{
        @Override
        public void walk() {
            System.out.println("婀娜多姿");
        }
    };

    //统一实现接口
    @Override
    public void run() {
        System.out.println("跑步");
    }
}
