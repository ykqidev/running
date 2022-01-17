package com.proj.code.thread.sale_review;

public class ReviewTest {
    public static void main(String[] args) {
        Runnable r1 = Gender.MAN;
        r1.run();

        Runnable r2 = Gender.WOMAN;
        r2.run();

        Walkable r3 = Gender.MAN;
        r3.walk();
        Walkable r4 = Gender.WOMAN;
        r4.walk();
    }
}
