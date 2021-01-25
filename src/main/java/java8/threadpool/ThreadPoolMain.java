package java8.threadpool;

import java.util.concurrent.*;

/**
 * @ Author ：com.wxw.
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
                        // todo 通过该线程初始化  priority, name, daemon status, {@code ThreadGroup}, etc
                        return null;
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy());
        BlockingQueue<Runnable> blockingQueue = taskExecutor.getQueue();
    }
}
