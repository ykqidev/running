package com.proj.juc.callable;

import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("========> call");
        return 1024;
    }
}
