package com.huey.learning.java.concurrent.thread.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class DataSourcesLoader implements Runnable {

    @Override
    public void run() {

        System.out.printf("Beginning data sources loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n", new Date());

    }

}
