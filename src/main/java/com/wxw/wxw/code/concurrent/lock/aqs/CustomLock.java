package com.wxw.wxw.code.concurrent.lock.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author ：com.wxw.wxw.
 * @date ： 11:43 2020/11/25
 * @description：基于AQS自定义锁 https://www.cnblogs.com/coding400/p/10453783.html#_label1
 * @version: v_0.0.1
 */
public class CustomLock {

    private final Sync sync;

    public CustomLock() {
        this.sync = new Sync();
    }

    public void lock(){
        sync.lock();
    }

    public void unlock(){
        sync.unlock();
    }


    static class Sync extends AbstractQueuedSynchronizer {

        void lock() {
            // 设置 非公平锁
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                acquire(1);
            }
        }

        void unlock() {
            release(1);
        }

        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;
            boolean success = false;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                success = true;
            }
            return success;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if(arg == 0){
                throw new IllegalMonitorStateException();
            }
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return Thread.currentThread() == getExclusiveOwnerThread();
        }

    }
}
