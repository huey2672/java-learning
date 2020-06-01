package com.huey.learning.java.concurrent.thread.interruption;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class DownloadTask implements Runnable {

    @Override
    public void run() {

        int percentage = 0;

        while (percentage < 100 && !Thread.currentThread().isInterrupted()) {

            percentage++;
            System.out.printf("Downloading: %d%%\n", percentage);

            // mock a time-consuming work
            for (long i = 0; i < Long.MAX_VALUE / Integer.MAX_VALUE / 10; i++) {
                ;
            }

        }

    }

}
