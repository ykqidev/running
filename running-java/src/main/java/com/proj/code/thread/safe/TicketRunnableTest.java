package com.proj.code.thread.safe;

/**
 * 二、继承Thread和实现Runnable接口的方式的区别：
 * （1）共享数据
 * Thread需要用静态
 * Runable不需要静态，只要用同一个MyRunnble的对象就可以。
 * （2）选择锁对象时，比较方便
 * Runnable可以直接用this对象，继承Thread的方式不能用this。
 * （3）继承有单继承限制，实现没有限制。
 */
public class TicketRunnableTest {
    public static void main(String[] args) {

        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr, "窗口一");
        Thread t2 = new Thread(mr, "窗口二");

        t1.start();
        t2.start();
    }
}

