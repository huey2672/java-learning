package com.huey.learning.java.concurrent.monitor;

import java.util.Random;

/**
 * 生产者
 *
 * @author huey
 */
public class Producer extends Thread {

    private final Storehouse storehouse;
    private final int count;

    public Producer(String name, Storehouse storehouse, int count) {
        super(name);
        this.storehouse = storehouse;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                // 生产消息
                storehouse.input(new Object());
                Thread.sleep(new Random().nextInt(100));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}