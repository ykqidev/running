package com.proj.code.interview;

import org.junit.Test;

public class InterviewTest {
    private static Long[] a = new Long[999999999];

    /**
     * java.lang.OutOfMemoryError
     */
    @Test
    public void method01(){
        System.out.println(new InterviewTest());
    }
}
