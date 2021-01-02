package com.wxw.wxw.code.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author ：com.wxw.wxw.
 * @ Date ： 12:22 2020/7/13
 * @ Description：原子操作
 * @ Version:   v_0.0.1
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        // AtomicInteger atomicInteger = new AtomicInteger(10); // 赋初始值为 10
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("atomicInteger = " + atomicInteger.get());

        // 修改值
        atomicInteger.set(100);

        // 获取当前值，然后设置新值
        System.out.println("atomicInteger.getAndSet(99) = " + atomicInteger.getAndSet(99)); // 100
        System.out.println("atomicInteger.get() = " + atomicInteger.get()); // 99

        // 获取当前值，然后对其 +20
        System.out.println("atomicInteger.getAndAdd(20) = " + atomicInteger.getAndAdd(20));
        System.out.println("atomicInteger.get() = " + atomicInteger.get());

        // lazyset 和 set 功能一样，但是不能保证立即修改值（最终会修改）
        atomicInteger.lazySet(100);
        System.out.println("atomicInteger.get() = " + atomicInteger.get());

        // 新增 1 并返回新值，原子操作
        System.out.println("atomicInteger.incrementAndGet() = " + atomicInteger.incrementAndGet());

        // CAS 原子操作 更改值
        System.out.println("atomicInteger.compareAndSet(102,1000) = " + atomicInteger.compareAndSet(102, 1000)); // false
        System.out.println("atomicInteger.compareAndSet(101,1000) = " + atomicInteger.compareAndSet(101, 1000)); // true

        System.out.println("atomicInteger = " + atomicInteger);
    }
}
