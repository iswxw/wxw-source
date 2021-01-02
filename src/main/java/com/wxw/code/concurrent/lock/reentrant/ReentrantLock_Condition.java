package com.wxw.code.concurrent.lock.reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：com.wxw.wxw.
 * @date ： 8:51 2020/11/25
 * @description：ReentrantLock.Condition线程之间通信——两个线程之间交替打印 26英文字母和阿拉伯数字
 * @version: v_0.0.1
 */
public class ReentrantLock_Condition {
    public static void main(String[] args) {



        // 交替打印字母和数字 notify() and wait()
        // LetterAndNumberPrint();
    }

    // 交替打印字母和数字
    private static void LetterAndNumberPrint() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Thread thread1 = new Thread(()->{
            try {
                lock.lock();
                for (int i = 65; i < 91; i++) {
                    System.out.printf("%s:%s \t",Thread.currentThread().getName(),(char)i);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"Thread1");

        Thread thread2 = new Thread(()->{
            try {
                lock.lock();
                for (int i = 1; i <= 26; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+ i);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"Thread2");

        thread1.start();
        thread2.start();
    }

}
