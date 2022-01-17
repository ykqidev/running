package com.proj.code.lambda;

import java.util.TreeSet;

public class FunctionTest {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>(String::compareToIgnoreCase);

        set.add("fon");
        set.add("TES");
        set.add("fds");
        set.add("pjk");

        set.forEach(System.out::println);


    }
}
