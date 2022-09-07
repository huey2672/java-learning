package com.huey.learning.java.concurrent.countdownlatch;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class DataSourcesLoader implements Runnable {

    private final CountDownLatch countDownLatch;

    public DataSourcesLoader(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.printf("Beginning data sources loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n", new Date());
        countDownLatch.countDown();

    }

}
