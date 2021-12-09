package com.huey.learning.java.concurrent.thread.factory;

import java.util.concurrent.ThreadFactory;

/**
 * @author huey
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setName("Daemon-" + thread.getName());
        return thread;
    }

}
