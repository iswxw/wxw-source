package java8.com.wxw.code.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 应用场景：可以用于多线程计算数据，最后合并计算结果的场景。
 * @author: wxw
 * @date: 2020-10-13-23:45
 */
public class CyclicBarrierDemo {
    static class TaskThread extends Thread {
        CyclicBarrier barrier;
        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        // final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        // cyclicBarrier.await();

        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });

        for(int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }

    }
}
/**
 * CountDownLatch 是一次性的，CyclicBarrier 是可循环利用的
 * CountDownLatch 参与的线程的职责是不一样的，有的在倒计时，有的在等待倒计时结束。
 * CyclicBarrier 参与的线程职责是一样的。
 */
