package com.wxw.code.threadpool;

/**
 * @author: com.wxw
 * @date: 2020-11-29-16:05
 */
public class MyTask implements Runnable {
    private int num;

    public MyTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("正在执行任务" + num);
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务" + num + "执行完毕");
    }
}
