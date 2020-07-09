package java8.com.wxw.code.concurrent;

/**
 * @Author: wxw
 * @create: 2020-04-25-16:56
 */
public class SynchronizedOne {

    public void syncBlock(){
        synchronized (this){
            System.out.println(" synchronized Block");
        }
    }

    public synchronized void syncMethod(){
        System.out.println(" synchronized method");
    }

}
