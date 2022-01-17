package com.proj.juc.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> integerFutureTask = new FutureTask<>(new MyCallable());
        new Thread(integerFutureTask, "A").start();

        System.out.println(integerFutureTask.get());
    }
}
