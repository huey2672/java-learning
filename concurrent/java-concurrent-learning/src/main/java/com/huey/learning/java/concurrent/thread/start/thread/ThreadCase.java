package com.huey.learning.java.concurrent.thread.start.thread;

/**
 * @author huey
 */
public class ThreadCase {

    public static void main(String[] args) {

        Thread myTask = new MyTask();
        myTask.start();

    }

}
