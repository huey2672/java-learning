package com.huey.learning.java.concurrent.thread.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class ThreadFactoryCase {

    public static void main(String[] args) {

        DaemonThreadFactory daemonThreadFactory = new DaemonThreadFactory();

        for (int i = 0; i < 3; i++) {
            Thread thread = daemonThreadFactory.newThread(new DaemonTask());
            thread.start();
        }

    }

    static class DaemonTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running.");
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
