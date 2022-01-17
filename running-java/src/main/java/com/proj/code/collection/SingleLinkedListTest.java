package com.proj.code.collection;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add("张三");
        singleLinkedList.add("李四");
        singleLinkedList.add("王五");
        singleLinkedList.add("赵六");
        System.out.println(singleLinkedList.size());

        Object[] objects = singleLinkedList.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        System.out.println();
        singleLinkedList.remove("张三");

        objects = singleLinkedList.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println();
        singleLinkedList.remove("王五");
        objects = singleLinkedList.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
