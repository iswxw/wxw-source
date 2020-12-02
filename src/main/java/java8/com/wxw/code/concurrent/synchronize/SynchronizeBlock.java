package java8.com.wxw.code.concurrent.synchronize;

/**
 * 用法是在函数体内部对于要修改的参数区间用synchronized来修饰，相比与锁定函数这个范围更小，可以指定锁定什么对象。
 *
 * @author ：wxw.
 * @date ： 16:12 2020/12/2
 * @description：synchronized修饰实例方法
 * @version: v_0.0.1
 */
public class SynchronizeBlock implements Runnable {

    //共享资源(临界资源)
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            //获得了String的类锁
            synchronized (String.class) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizeBlock t = new SynchronizeBlock();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
