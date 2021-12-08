package com.huey.learning.java.concurrent.thread.daemon;

/**
 * @author huey
 */
public class DaemonCase {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("I'm a daemon thread.");
            }
        });
        thread.setDaemon(true);
        thread.start();

        boolean daemon = thread.isDaemon();
        System.out.println("The thread is daemon or not? " + daemon);

    }

}
