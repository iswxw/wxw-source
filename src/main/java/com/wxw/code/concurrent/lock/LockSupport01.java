package com.wxw.code.concurrent.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: com.wxw
 * @date: 2020-10-07-16:03
 */
public class LockSupport01 {
    public static void main(String[] args) throws InterruptedException {
        // LockSupport

        // 开启子线程 先挂起线程，再释放
        // parkAndUnpark01();

        // 通过中断子线程释放许可
        parkAndUnpark02();

    }

    private static void parkAndUnpark02() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");
                while (!Thread.currentThread().isInterrupted()){
                    // 调用park方法，挂起自己，只有被中断才ui退出循环
                    LockSupport.park();
                }
                System.out.println("child thread unpark!");
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark!");
        // 中断子线程
        thread.interrupt();
    }


    // 开启子线程 先挂起线程，再释放
    private static void parkAndUnpark01() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");
                // 调用park方法，挂起自己
                LockSupport.park();

                System.out.println("child thread unpark!");
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark!");
        // 调用unpark方法让thread线程持有许可证，然后park方法返回
        //LockSupport.unpark(thread);

        // 中断子线程
        thread.interrupt();
    }


    // 先许可，再获取许可会马上释放
    public void test1(){
        System.out.println("begin park! ");
        // 使用unpark使当前线程获取到许可证
        LockSupport.unpark(Thread.currentThread());
        // 再次调用park方法
        LockSupport.park();

        System.out.println("end park! ");
    }
}

 class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean((false));
    private final Queue<Thread> waiters = new ConcurrentLinkedDeque<Thread>();

    // 基于队列加锁
    public void lock(){
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        // 只有队首的线程可以获取锁(1)
        while (waiters.peek() != current || !locked.compareAndSet(false, true)){
            LockSupport.park(this);
            if (Thread.interrupted()){ // (2)
                wasInterrupted = true;
            }
        }

        waiters.remove();
        if (wasInterrupted){ // (3)
            current.interrupt();
        }
    }
   // 释放锁
    public void unlock(){
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}

