package com.proj.code.thread.deadlock;

public class TestDeadLock {
    public static void main(String[] args) {

        Boy t1 = new Boy("girl","money");
        Bang t2 = new Bang("girl","money");

        t1.start();
        t2.start();
    }
}

