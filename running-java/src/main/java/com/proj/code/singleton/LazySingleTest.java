package com.proj.code.singleton;

public class LazySingleTest {
    public static void main(String[] args) {
        Lazy lazy = Lazy.getInstance();
        LazyDemo lazyDemo = LazyDemo.getInstance();

    }

    static class Lazy {
        private static volatile Lazy INSTANCE;

        private Lazy() {
            System.out.println(Thread.currentThread().getName() + ":构造方法");
        }

        public static Lazy getInstance() {
            if (INSTANCE == null) {
                synchronized (Lazy.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new Lazy();
                    }
                }
            }
            return INSTANCE;
        }
    }

    // 内部类
    static class LazyDemo{

        private static class Inner{
            protected static final LazyDemo INSTANCE = new LazyDemo();
        }

        public static LazyDemo getInstance(){
            return Inner.INSTANCE;
        }
    }
}


