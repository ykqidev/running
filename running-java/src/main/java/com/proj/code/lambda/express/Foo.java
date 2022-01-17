package com.proj.code.lambda.express;

@FunctionalInterface
interface Foo{
    void add();

    default int ff(int x, int y){
        return x * y;
    }

    static int ee(int x, int y){
        return x % y;
    }
}
