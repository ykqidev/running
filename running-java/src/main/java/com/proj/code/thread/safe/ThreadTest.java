package com.proj.code.thread.safe;

public class ThreadTest {

    public static void main(String[] args) {
        TicketSaler ts1 = new TicketSaler("窗口一");
        TicketSaler ts2 = new TicketSaler("窗口二");

        ts1.start();
        ts2.start();
    }
}
