package com.huey.learning.java.concurrent.thread.threadlocal;

import java.util.Date;

/**
 * @author huey
 */
public class ThreadLocalNotGoodPractice {

    public static void main(String[] args) {

        Runnable task = new Runnable() {
            private Date dateVar;

            public void run() {
                dateVar = new Date();
                System.out.printf("%s, GET dateVar: %s\n", Thread.currentThread().getName(), dateVar);
                try {
                    Thread.sleep(5000L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s, FINAL dateVar: %s\n", Thread.currentThread().getName(), dateVar);
            }
        };

    }

}
