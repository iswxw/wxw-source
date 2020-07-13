package java8.com.wxw.code.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author ：wxw.
 * @ Date ： 12:22 2020/7/13
 * @ Description：原子操作
 * @ Version:   v_0.0.1
 */
public class AtomicInteger01 {
    private AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        AtomicInteger01 atomic = new AtomicInteger01();
        System.out.println("atomic.getCount() = " + atomic.getCount());
        System.out.println("atomic.increment() = " + atomic.increment());
    }

    // 获取当前数
    public  Integer getCount(){
        return atomicInteger.get();
    }

    // 原子操作 自增1
    public Integer increment(){
        return atomicInteger.incrementAndGet();
    }
}
