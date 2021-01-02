package com.wxw.code.concurrent.synchronize;

/**
 * synchronized关键词作用在方法的前面，用来锁定方法，其实默认锁定的是this对象
 * @author ：com.wxw.wxw.
 * @date ： 16:12 2020/12/2
 * @description：synchronized修饰实例方法
 * @version: v_0.0.1
 */
public class SynchronizeInstanceMethod implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        SynchronizeInstanceMethod t = new SynchronizeInstanceMethod();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
        t1.join();//主线程等待t1执行完毕
        t2.join();//主线程等待t2执行完毕
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }

    //共享资源(临界资源)  volatile 只能保证可见性，不能保证原子性
    static int i = 0;

    //如果没有synchronized关键字，输出小于20000
    public synchronized void increase() {
        i++;
    }

//    public /*synchronized*/ void increase() {
//        i++;
//    }
}
