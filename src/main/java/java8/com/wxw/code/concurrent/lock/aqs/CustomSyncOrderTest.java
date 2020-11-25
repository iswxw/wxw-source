package java8.com.wxw.code.concurrent.lock.aqs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author ：wxw.
 * @date ： 11:48 2020/11/25
 * @description：利用自定义的锁 进行同步订单测试
 * @version: v_0.0.1
 */
public class CustomSyncOrderTest {

    private static CustomLock lock = new CustomLock();

    public static void main(String[] args) throws InterruptedException {
        /**
         * 利用自定义的锁 进行同步订单测试
         * 通过开启2个线程来对SyncOrderLock中的getOrderNo产生竞争，导致阻塞。可以清楚的见到实际上 用AQS来实现自定义的锁，在已有的concurrent包下已够用
         */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SyncOrderLock();
            }
        },"线程1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SyncOrderLock();
            }
        },"线程2");
        System.out.println("t1:"+t1.getName());
        System.out.println("t2:"+t2.getName());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    // 利用自定义的锁 进行同步订单测试
    private static void SyncOrderLock() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "--" + SimpleDateFormat.getTimeInstance(SimpleDateFormat.FULL).format(new Date()));
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}
