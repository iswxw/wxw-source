package com.wxw.code.concurrent.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://www.itzhai.com/the-introduction-and-use-of-a-countdownlatch.html
 * @author: com.wxw.wxw
 * @document: 倒计数锁存器
 * @date: 2020-10-13-23:29
 */
@Slf4j
public class DemoCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch downLatch = new CountDownLatch(1); // 计数器
        /**
         * 递减锁存器的计数：
         *    如果计数到达零，则释放所有等待的线程。如果当前计数大于零，则将计数减少。
         *    如果新的计数为零，出于线程调度目的，将重新启用所有的等待线程。
         *    如果当前计数等于零，则不发生任何操作。
         */
        downLatch.countDown(); // 线程数 减一
        downLatch.await(); // 一直休眠直到减为0时，释放所有等待线程

        // 模拟了100米赛跑，10名选手已经准备就绪，只等裁判一声令下。当所有人都到达终点时，比赛结束
        RaceWith10Man();
    }

    /**
     * 一个CountDouwnLatch实例是不能重复使用的，也就是说它是一次性的，锁一经被打开就不能再关闭使用了，
     *  如果想重复使用，请考虑使用CyclicBarrier
     */

    // 模拟了100米赛跑，10名选手已经准备就绪，只等裁判一声令下。当所有人都到达终点时，比赛结束。
    private static void RaceWith10Man() throws InterruptedException {
        // 开始的倒数锁
        final CountDownLatch begin = new CountDownLatch(1);

        // 结束的倒数锁
        final CountDownLatch end = new CountDownLatch(10);

        // 十名选手
        final ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 如果当前计数为零，则此方法立即返回。
                        // 等待
                        begin.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + NO + " arrived");
                    } catch (InterruptedException e) {
                        log.info(e.toString(),e);
                    } finally {
                        // 每个选手到达终点时，end就减一
                        end.countDown();
                    }
                }
            };
            exec.submit(run);
        }
        System.out.println("Game Start");
        // begin减一，开始游戏
        begin.countDown();
        // 等待end变为0，即所有选手到达终点
        end.await();
        System.out.println("Game Over");
        exec.shutdown();
    }

}
