package jdk8.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://mp.weixin.qq.com/s/D4dQKa4VUWdrzhg2RAkLAA
 * @author: com.wxw
 * @date: 2020-11-29-16:04
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 15, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 20; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数量：" + executor.getPoolSize() + "、任务队列中等待执行的任务数量：" +
                    executor.getQueue().size() + "、执行完成的任务数量：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

}