package com.proj.juc;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 1 故障现象
 * java.util.ConcurrentModificationException
 * <p>
 * 2 导致原因
 * <p>
 * 3 解决方法
 * 3.1 new Vector<>()
 * 3.2 Collections.synchronizedList(new ArrayList<>());
 * 3.3 new CopyOnWriteArrayList()
 * <p>
 * <p>
 * 4 优化建议(同样的错误不犯第2次)
 */
public class NotSafeDemo {

    public static void main(String[] args) {

        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>(); // Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set.toString());
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>(); // Collections.synchronizedList(new ArrayList<>()); // new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list.toString());
            }, String.valueOf(i)).start();
        }
    }
}
