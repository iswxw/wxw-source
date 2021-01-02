package com.wxw.code.concurrent.lock.aqs.case1;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author ：com.wxw.wxw.
 * @date ： 14:01 2020/11/25
 * @description：自定义同步工具
 * @version: v_0.0.1
 */
public class LeeLock {

    private Sync sync = new Sync();

    public void lock() { sync.acquire(1); }

    public void unlock() { sync.release(1); }

    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() { return getState() == 1; }
    }
}
