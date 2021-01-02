package com.wxw.wxw.code.concurrent.synchronize;

/**
 * synchronized还是修饰在方法上，不过修饰的是静态方法，等价于锁定的是Class对象，
 *
 * @author ：com.wxw.wxw.
 * @date ： 16:19 2020/12/2
 * @description：synchronized修饰静态方法
 * @version: v_0.0.1
 */
public class SynchronizeStaticMethod {
    //共享资源(临界资源)
    static int i = 0;

    //如果没有synchronized关键字，输出小于20000
    public static synchronized void increase() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();//主线程等待t1执行完毕
        t2.join();//主线程等待t2执行完毕
        System.out.println(i);
    }
}
