package com.huey.learning.java.common.sample;

import java.time.Duration;
import java.time.Instant;

/**
 * @author huey
 */
public class Java8APISample {

    public static void main(String[] args) {

        Instant start = Instant.now();

        // some codes

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

    }

}
