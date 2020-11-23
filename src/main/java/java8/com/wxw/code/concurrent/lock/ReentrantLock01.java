package java8.com.wxw.code.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author ：wxw.
 * @ Date ： 13:49 2020/9/18
 * @ Description：jdk级别的锁
 * @ Version:   v_0.0.1
 */
public class ReentrantLock01 {

    // ReentrantLock
    // https://blog.csdn.net/qq_41893274/article/details/105554149
    public static ReentrantLock reentrantLock = new ReentrantLock();
    int count = 0;

    public static void main(String[] args) {
        ReentrantLock01 lock = new ReentrantLock01();
        lock.run();
    }

    public void run() {
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
