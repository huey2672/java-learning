package com.huey.learning.java.common.sample;

/**
 * @author huey
 */
public class CurrentTimeMillisSample {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // some codes

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

    }

}
