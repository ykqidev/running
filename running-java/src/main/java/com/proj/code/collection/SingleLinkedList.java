package com.proj.code.collection;

/**
 * 自定义一个单向链表
 * 底层不是用数组，用结点类型
 */
public class SingleLinkedList {
    private int total;
    private Node first;

    public void add(Object obj) {
        if (first == null) {
            first = new Node(obj, null);
        } else {
            Node now = first;
            while (now.next != null) {
                now = now.next;
            }
            now.next = new Node(obj, null);
        }
        total++;
    }

    public void remove(Object obj) {
        if (obj == null) {
            if (first.data == null) {
                first = first.next;
            } else {
                Node left = first;
                Node now = first.next;
                while (now.data != null) {
                    left = now;
                    now = now.next;
                }
                left.next = now.next;
            }
        } else {
            if (obj.equals(first.data)) {
                first = first.next;
            } else {
                Node left = first;
                Node now = first.next;
                while (!obj.equals(now.data)) {
                    left = now;
                    now = now.next;
                }
                left.next = now.next;
            }
        }
        total--;
    }

    public int size() {
        return total;
    }

    public Object[] toArray() {

        Object[] objects = new Object[total];
        Node node = first;
        for (int i = 0; i < objects.length; i++) {
            objects[i] = node.data;
            node = node.next;
        }
        return objects;
    }


    static class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
