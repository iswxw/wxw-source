package com.wxw.code.concurrent.lock.aqs;

/**
 * @ Author ：com.wxw.wxw.
 * @ Date ： 10:47 2020/9/18
 * @ Description：同步队列 https://www.jianshu.com/p/6e8e5a12286c
 * @ Version:   v_0.0.1
 *  1， park/unpark : park译为“停车”，官方文档意为：许可。为了方便理解，
 *       在这里我们可以理解为阻塞，等待，挂起，而unpark我们理解为唤醒，恢复。
 */
public class AQS {
    public static void main(String[] args) {
        // AbstractQueuedSynchronizer
        System.out.printf("检查当前状态是否被中断过 : %s \n",Thread.interrupted());
    }
}
