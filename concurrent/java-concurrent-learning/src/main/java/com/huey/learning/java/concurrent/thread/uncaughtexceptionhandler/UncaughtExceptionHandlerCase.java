package com.huey.learning.java.concurrent.thread.uncaughtexceptionhandler;

/**
 * @author huey
 */
public class UncaughtExceptionHandlerCase {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> Integer.parseInt(""));
        thread.setUncaughtExceptionHandler(new MyExceptionHandler());
//        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
        thread.start();

    }

}
