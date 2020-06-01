package com.huey.learning.java.concurrent.thread.interruption;

import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class InterruptCase {

    public static void main(String[] args) throws Exception {

        Thread downloadTask = new Thread(new DownloadTask());
        downloadTask.start();

        TimeUnit.SECONDS.sleep(5);
        downloadTask.interrupt();

    }

}
