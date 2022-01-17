package com.proj.code.lambda;

import java.util.ArrayList;

public class PredicateTest {

    public static void main(String[] args) {
//        Stream stream = Stream.of(1, 2, 3.5, 6, 4, 6, 7, 8, 9).filter(t -> t % 2 == 0);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        arr.removeIf(t -> t % 2 == 0);
        arr.forEach(System.out::println);

    }
}
