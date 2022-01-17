package com.proj.code.collection;

import org.junit.Test;

import java.util.Random;

public class ArraycopyTest {
    public static void main(String[] args) {
        String[] arr = new String[5];
        arr[0] = "java";
        arr[1] = "android";
        arr[2] = "string";
        arr[3] = "hello";
        arr[4] = "world";

        int total = 5;
        int index = 1;
        System.arraycopy(arr,index+1,arr,index,total-index-1);
        arr[--total] = null;

        for (String s : arr) {
            System.out.println(s);
        }
    }

    @Test
    public void testMethod() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt();
            while (i1>1000||i1<0){
                i1 = random.nextInt();
            }
            System.out.println(i1);
        }
    }
}
