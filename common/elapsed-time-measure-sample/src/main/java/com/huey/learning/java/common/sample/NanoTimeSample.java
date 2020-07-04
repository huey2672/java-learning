package com.huey.learning.java.common.sample;

/**
 * @author huey
 */
public class NanoTimeSample {

    public static void main(String[] args) {

        long start = System.nanoTime();

        // some codes

        long finish = System.nanoTime();
        long timeElapsed = finish - start;

    }

}
