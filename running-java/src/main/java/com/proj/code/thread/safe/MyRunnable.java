package com.proj.code.thread.safe;

class MyRunnable implements Runnable {

    private TicketService ticketService = new TicketService();

    @Override
    public void run() {
        // 同步代码块
//        while (true){
//            synchronized (this){
//                if(ticketService.hasTicket()){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "已经销售出"+ticketService.sale());
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

    // 非静态方法，锁对象是this
    private synchronized void saleOneTicket() {
        if (ticketService.hasTicket()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "已经销售出" + ticketService.sale());
        }
    }
}
