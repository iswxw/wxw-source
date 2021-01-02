package com.wxw.wxw.code.concurrent.lock;

/**
 * @ Author ：com.wxw.wxw.
 * @ Date ： 12:35 2020/7/13
 * @ Description：轻量级的锁
 * @ Version:   v_0.0.1
 */
public class Volatile01 {
    private volatile int count;

    public static void main(String[] args) {

    }

    public Integer getCount(){
        return count;
    }

    public synchronized void increment(){
        count++;
    }
}

/**
（1）volatile可见性、一致性、不具有原子性
 就是在一个线程的工作内存中修改了该变量的值，该变量的值立即能回显到主内存中，从而保证所有的线程看到这个变量的值是一致的
 (2) 单例模式中解决了 重排序的问题

 注意：因为它不具有操作的原子性，也就是它不适合在对该变量的写操作依赖于变量本身自己，如果
 想避免并发的问题、需要加synchronized （如上）或者 atomic类
 */
