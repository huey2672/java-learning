package com.huey.learning.java.concurrent.lock.condition;

import java.util.Random;

/**
 * 消费者
 *
 * @author huey
 */
public class Consumer extends Thread {

    private final Storehouse storehouse;
    private final int count;

    public Consumer(String name, Storehouse storehouse, int count) {
        super(name);
        this.storehouse = storehouse;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                // 消费消息
                storehouse.output();
                Thread.sleep(new Random().nextInt(100));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}