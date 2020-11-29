package java8.com.wxw.code.study;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wxw
 * @create: 2020-04-25-23:53
 */
public class ThreadPoolOne {
    public static void main(String[] args) {
//        ThreadPoolExecutor
//        Executors
        System.out.println("查看CPU核数:"+Runtime.getRuntime().availableProcessors());
    }
}
