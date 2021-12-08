package com.huey.learning.java.concurrent.thread.sleep;

/**
 * @author huey
 */
public class ThreadSleepCase {

    public static void main(String[] args) {

        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
