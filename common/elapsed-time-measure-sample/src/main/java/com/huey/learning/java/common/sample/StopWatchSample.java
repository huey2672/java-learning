package com.huey.learning.java.common.sample;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class StopWatchSample {

    public static void main(String[] args) {

        StopWatch watch = StopWatch.createStarted();

        // some codes

        watch.stop();
        long timeElapsed = watch.getTime(TimeUnit.MILLISECONDS);

    }

}
