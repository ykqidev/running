package com.proj.juc.ticket_demo;

/**
 * 题目：三个售票员         卖出          30张票
 * 笔记：如何编写企业级的多线程代码
 * 固定的编程套路+模板是什么？
 * <p>
 * 1 在高内聚低耦合的前提下，线程        操作      资源类
 * <p>
 * 1.1 一言不合，先创建一个资源类
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 40; i1++) ticket.sale();
            }, "" + i).start();
        }
    }
}


