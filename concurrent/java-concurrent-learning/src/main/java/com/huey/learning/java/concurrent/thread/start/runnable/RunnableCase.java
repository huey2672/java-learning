package com.huey.learning.java.concurrent.thread.start.runnable;

/**
 * @author huey
 */
public class RunnableCase {

    public static void main(String[] args) {

        Thread myTask = new Thread(new MyTask());
        myTask.start();

    }

}
