package com.wxw.wxw.code.concurrent.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author com.wxw.wxw
 * @author Dell
 * @ Date ： 13:49 2020/9/18
 * @ Description：jdk级别的锁  csdn：https://blog.csdn.net/qq_41893274/article/details/105554149
 * @ Version:   v_0.0.1
 */
public class ReentrantLock_Sync {
    // ReentrantLock
    public static ReentrantLock reentrantLock = new ReentrantLock(true);
    public static int count = 0;

    public static void main(String[] args) {

        // 同步功能
        run();
        System.out.println("计算结果 = " + count);
    }

    public static void run() {
        // 加锁
        reentrantLock.lock();
        try {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
