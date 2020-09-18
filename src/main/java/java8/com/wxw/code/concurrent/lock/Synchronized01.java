package java8.com.wxw.code.concurrent.lock;

/**
 * @ Author ：wxw.
 * @ Date ： 17:02 2020/9/16
 * @ Description：同步锁
 * @ Version:   v_0.0.1
 * 链接地址：https://github.com/farmerjohngit/myblog/issues/12
 */
public class Synchronized01 {
    public static void main(String[] args) {

        // synchronized

    }

    // 对象锁
    public void syncBlock() {
        synchronized (this) {
            System.out.println("hello block");
        }
    }

    // 方法锁
    public synchronized void syncMethod() {
        System.out.println("hello method");
    }
}
