package edu.feng.code.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: juc-test
 * @description: 锁类
 * @author: feng
 * @create: 2023-02-26 11:40
 * @version: 1.0
 */
public class LuoLock {
    public static class Sync extends AbstractQueuedSynchronizer {
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
        protected boolean isHeldExclusively () {
            return getState() == 1;
        }
    }

    private Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }
}