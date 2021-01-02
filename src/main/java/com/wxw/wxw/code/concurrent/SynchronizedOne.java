package com.wxw.wxw.code.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: com.wxw.wxw
 * @create: 2020-04-25-16:56
 */
public class SynchronizedOne {
    public static void main(String[] args) {
        Lock lock = new Lock() {
            @Override
            public void lock() {

            }

            @Override
            public void lockInterruptibly() throws InterruptedException {

            }

            @Override
            public boolean tryLock() {
                return false;
            }

            @Override
            public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public void unlock() {

            }

            @Override
            public Condition newCondition() {
                return null;
            }
        };
    }

    /**
     * 同步块
     */
    public void syncBlock(){
        synchronized (this){
            System.out.println(" synchronized Block");
        }
    }

    /**
     * 同步方法
     */
    public synchronized void syncMethod(){
        System.out.println(" synchronized method");
    }

}
