package com.wxw.code.concurrent.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：com.wxw.
 * @date ： 9:22 2020/11/25
 * @description：非重要任务Lock的使用
 * @version: v_0.0.1
 *
 * tryLock()功能：如果已经获得锁立即返回 false，起到防止重复而忽略的效果
 */
public class ReentrantLock_TryLock {

    public static void main(String[] args) {

        // 超时放弃
        // OverTimeAbandon();


        // 忽略重复触发
        // AvoidDuplicate();
    }

    // 超时放弃
    // 例如：错误日志、定时过期缓存清理的操作，遇到优先级更高的操作占用资源时，暂时放弃本次操作下次再处理，可以起到让出CPU，提升用户体验
    private static void OverTimeAbandon() {
        ReentrantLock lock = new ReentrantLock();
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                //TODO
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 常用实例：清除无用临时文件，检查某些资源的可用性，数据备份操作
    private static void AvoidDuplicate() {
        ReentrantLock lock = new ReentrantLock();
        //防止重复执行，执行耗时操作，例如用户重复点击（多次点击 不是同一个线程,所以返回的是false）
        if (lock.tryLock()) {
            try {
                //TODO
            } finally {
                lock.unlock();
            }
        }
    }


}
