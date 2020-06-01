package com.huey.learning.java.concurrent.thread.interruption;

import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class InterruptedExceptionCase {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // Creates the Runnable object and the Thread to run it
        FileSearcher searcher = new FileSearcher("/Users/zhisenzheng", "pom.xml");
        Thread thread = new Thread(searcher);

        // Starts the Thread
        thread.start();

        // Wait for 3 seconds
        TimeUnit.SECONDS.sleep(3);

        // Interrupts the thread
        thread.interrupt();

    }

}
