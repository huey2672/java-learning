package com.huey.learning.java.concurrent.thread.sleep;

import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class TimeUnitCase {

    public static void main(String[] args) {

        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
