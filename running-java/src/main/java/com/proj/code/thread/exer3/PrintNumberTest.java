package com.proj.code.thread.exer3;

/**
 * 间隔打印奇数偶数
 */
public class PrintNumberTest {

    public static void main(String[] args) {

        Oop t1 = new Oop("奇数");
        Even t2 = new Even("偶数");

        t1.start();
        t2.start();

    }
}

