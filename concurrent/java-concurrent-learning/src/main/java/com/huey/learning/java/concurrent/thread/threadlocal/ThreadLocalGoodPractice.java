package com.huey.learning.java.concurrent.thread.threadlocal;

import java.util.Date;

/**
 * @author huey
 */
public class ThreadLocalGoodPractice {

    public static void main(String[] args) {

        Runnable task = new Runnable() {
            private final ThreadLocal<Date> dateVar = new ThreadLocal<>();
            public void run() {
                dateVar.set(new Date());
                System.out.printf("%s, GET dateVar: %s\n", Thread.currentThread().getName(), dateVar.get());
                try {
                    Thread.sleep(5000L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s, FINAL dateVar: %s\n", Thread.currentThread().getName(), dateVar.get());
            }
        };

        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(task, "Thread-" + i);
            thread.start();
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
