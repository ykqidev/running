package com.proj.code.nio;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CocurrentHashMap 在 JAVA8 中存在一个 bug，会进入死循环，原因是递归创建 ConcurrentHashMap 对象，
 * 但是在 1.9 已经修复了
 */
public class ConcurrentHashMapTest {
    private Map<Integer, Integer> cache = new ConcurrentHashMap<>(15);

    public static void main(String[] args) {
        ConcurrentHashMapTest ch = new ConcurrentHashMapTest();
        System.out.println(ch.fibonaacci(80));
    }

    public int fibonaacci(Integer i) {
        if (i == 0 || i == 1) {
            return i;
        }

        return cache.computeIfAbsent(i, (key) -> {
            System.out.println("fibonaacci : " + key);
            return fibonaacci(key - 1) + fibonaacci(key - 2);
        });
    }
}
