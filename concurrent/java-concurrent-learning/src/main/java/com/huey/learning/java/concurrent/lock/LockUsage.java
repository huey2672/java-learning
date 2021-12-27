package com.huey.learning.java.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huey
 */
public class LockUsage {

    Lock lock = new ReentrantLock();

    void lockCase() {
        Lock l = lock;
        try {
            l.lock();
            // access the resource protected by this lock
        }
        finally {
            l.unlock();
        }
    }

    void tryLockCase() {
        Lock l = lock;
        if (l.tryLock()) {
            try {
                // manipulate protected state
            }
            finally {
                l.unlock();
            }
        }
        else {
            // perform alternative actions
        }

    }

}
