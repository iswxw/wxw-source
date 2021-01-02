package com.wxw.wxw.code.corn;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ Author ：com.wxw.wxw.
 * @ Date ： 14:38 2020/10/13
 * @ Description：定时器
 * @ Version:   v_0.0.1
 */
public class TimerDemo {
    public static void main(String[] args) {
        // 在1s后执行一次任务，然后每个2秒执行一次
        timer_01("A");
        timer_01("B");
    }
    // 在1s后执行一次任务，然后每个2秒执行一次
    private static void timer_01(String taskName) {
        Timer timer = new Timer(taskName);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Thread.currentThread() = " + Thread.currentThread().getName());
            }
        }, 1000, 2000);

//        timer.cancel(); // 取消
//        timer.purge();  // 清除
    }
}
