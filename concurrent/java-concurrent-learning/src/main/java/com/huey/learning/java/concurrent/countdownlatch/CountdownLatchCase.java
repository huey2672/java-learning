package com.huey.learning.java.concurrent.countdownlatch;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author huey
 */
public class CountdownLatchCase {

    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        // creates the loading tasks
        Thread dataSourcesLoader = new Thread(new DataSourcesLoader(countDownLatch));
        Thread networkConnectionsLoader = new Thread(new NetworkConnectionsLoader(countDownLatch));

        // runs the tasks
        dataSourcesLoader.start();
        networkConnectionsLoader.start();

        // waits for count down to 0.
        countDownLatch.await();

        // does other things
        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());

    }

}
