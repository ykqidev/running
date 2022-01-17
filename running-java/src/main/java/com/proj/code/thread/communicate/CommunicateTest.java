package com.proj.code.thread.communicate;

import org.junit.Test;

/**
 * 例如：把厨师当做一个线程，服务员当做一个线程，然后把“出菜的窗口的平台”当做“数据的缓存区”
 * 厨师外“平台”放菜，服务器从“平台”去菜
 */
public class CommunicateTest {

    /**
     * 当厨师和服务员都是多个时
     *
     * 要点：
     * （1）notify换成notifyAll()
     * （2）被notify唤醒后，要确保重写判断条件
     * 第一种：
     *       while(条件){
     *           xx.wait();
     *       }
     *       业务代码
     * 第二种：
     *       if(条件){
     *           xx.wait();
     *       }else{
     *           业务代码
     *       }
     *
     * wait和notify方法在Object类中声明，为什么？
     * 因为我们要用“同步锁”对象，而“同步锁”对象可以是任意类型。
     *
     * notify：唤醒在此对象监视器上等待的单个线程，如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。
     * notifyAll：唤醒在此对象监视器上等待的所有线程。
     */
    @Test
    public void method02(){

        WorkBench workBench = new WorkBench();
        Cook c1 = new Cook(workBench);
        Cook c2 = new Cook(workBench);
        Waiter w1 = new Waiter(workBench);
        Waiter w2 = new Waiter(workBench);
        Waiter w3 = new Waiter(workBench);

        c1.start();
        c2.start();
        w1.start();
        w2.start();
        w3.start();
    }
    

    /**
     * 例如：把厨师当做一个线程，服务员当做一个线程，然后把“出菜的窗口的平台”当做“数据的缓存区”
     * 厨师外“平台”放菜，服务器从“平台”去菜
     */
    @Test
    public void method01(){
        WorkBench workBench = new WorkBench();
        Cook t1 = new Cook(workBench);
        Waiter t2 = new Waiter(workBench);

        t1.start();
        t2.start();
    }
}

