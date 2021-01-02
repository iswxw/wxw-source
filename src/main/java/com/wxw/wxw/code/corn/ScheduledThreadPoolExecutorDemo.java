package com.wxw.wxw.code.corn;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ Author ：com.wxw.wxw.
 * @ Date ： 15:12 2020/10/13
 * @ Description：线程池设计定时任务
 * @ Version:   v_0.0.1
 */
public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2,new ThreadPoolExecutor.CallerRunsPolicy());
        scheduledExecutorDemo(scheduledThreadPoolExecutor);
    }

    // 第一次启动执行的延迟 0ms，启动后 每隔2s执行一次
    private static void scheduledExecutorDemo(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        // 按固定频率执行
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("B:"+Thread.currentThread().getName());
            }
        },1,2, TimeUnit.SECONDS); // 第一次启动执行的延迟 1s，启动后 每隔2s执行一次

        // 按固定频率执行
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("A:"+Thread.currentThread().getName());
            }
        },1,2, TimeUnit.SECONDS); // 第一次启动执行的延迟 1s，启动后 每隔2s执行一次
    }
}
