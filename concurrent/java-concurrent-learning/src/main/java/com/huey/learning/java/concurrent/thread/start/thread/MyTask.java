package com.huey.learning.java.concurrent.thread.start.thread;

/**
 * @author huey
 */
public class MyTask extends Thread {

    @Override
    public void run() {
        System.out.println("Hello, World!");
    }
}
