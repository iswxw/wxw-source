package java8.com.wxw.code.concurrent.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wxw.
 * @date ： 9:14 2020/11/25
 * @description：响应中断
 * @version: v_0.0.1
 */
public class ReentrantLock_interruptibility {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lockInterruptibly();
            if (lock.tryLock(2, TimeUnit.SECONDS)){
                // TODO
            }else {
                // 超时直接中断优先级低的Task
                Thread.currentThread().interrupt();
                lock.lock();
                // TODO
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
