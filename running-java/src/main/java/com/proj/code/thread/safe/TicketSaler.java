package com.proj.code.thread.safe;

/**
 * 一、两个线程使用了共享的同一份数据，就有线程的安全问题。
 * 1、如何判断？
 * （1）是否有多个线程使用同一个数据
 * （2）并且有多条语句来操作和访问这个共享数据
 * <p>
 * 2、如何解决？加锁
 * 同步：
 * （1）同步的锁对象可以是任意类型的对象。
 * （2）使用共享数据的这些线程，使用（承认）同一个锁对象。
 * <p>
 * 3、两种形式：
 * （1）同步代码块
 * 语法格式：
 * synchronized(同步的锁对象){
 * 需要锁起来的代码：一个线程在运行这段代码期间，不想别的线程半路插进来。
 * }
 * 和共享数据相关的语句都要锁进来
 * （2）同步方法
 * 如果你的一次任务是在一个方法中完成的，那么我可以直接锁一个方法。
 * 语法格式：
 * 【修饰符】synchronized 返回值类型 方法名(【形参类别】)【throws 异常列表】{}
 * 同步方法的锁对象：
 * 非静态方法：this（在继承Thread中不能用this） 要考量是否适合当锁对象
 * 静态方法：当前类的Class对象
 * 每一个类型被记载到内存中都会生成一个Class对象来表示这个类型，只要是同一个类型，Class对象就是同一个。
 */
public class TicketSaler extends Thread {

    private static TicketService ticketService = new TicketService();

    public TicketSaler(String name) {
        super(name);
    }

    @Override
    public void run() {

        // 同步代码块
//        while (true){
//            synchronized (ticketService){
//                if(ticketService.hasTicket()){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(getName() + "已经销售出"+ticketService.sale());
//                }else {
//                    break;
//                }
//            }
//        }


        // 同步方法
        while (ticketService.hasTicket()) {
            saleOneTicket();
        }
    }

    // 错误的，因为非静态方法的默认锁对象是this,继承这种方式，用this不行
//    public synchronized void saleOneTicket() {
//        if (ticketService.hasTicket()) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "卖出去" + ticketService.sale());
//        }
//    }

    // 静态方法的锁对象，是当前类的Class对象
    public synchronized static void saleOneTicket() {
        if (ticketService.hasTicket()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出去" + ticketService.sale());
        }
    }
}
