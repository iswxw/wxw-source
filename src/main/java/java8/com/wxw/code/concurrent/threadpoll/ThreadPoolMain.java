package java8.com.wxw.code.concurrent.threadpoll;

import java.util.concurrent.*;

/**
 * @ Author ：wxw.
 * @ Date ： 16:27 2020/8/22
 * @ Description：线程池的使用
 * @ Version:   v_0.0.1
 */
public class ThreadPoolMain {

    public static void main(String[] args) {
        ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(
                10,
                50,
                60, TimeUnit.SECONDS,
                 new LinkedBlockingQueue<Runnable>(),
                 new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {

                        return null;
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy());

        BlockingQueue<Runnable> blockingQueue = taskExecutor.getQueue();

    }
}
