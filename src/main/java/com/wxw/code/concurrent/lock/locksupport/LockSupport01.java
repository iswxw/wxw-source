package com.wxw.code.concurrent.lock.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ：com.wxw.wxw.
 * @date ： 11:45 2020/12/7
 * @description：
 * @link:
 * @version: v_0.0.1
 */
public class LockSupport01 {
    public static void main(String[] args) {

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("i = " + i);
                    LockSupport.park();
                }
            }
        },"thread-A");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 65; i < 75; i++) {
                    System.out.println("i = " + (char)i);
                    LockSupport.park();
                }
            }
        },"thread-B");
        A.start();
        B.start();
        LockSupport.unpark(A);
        LockSupport.unpark(B);



    }
}
