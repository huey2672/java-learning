package com.huey.learning.java.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Runner implements Runnable {

    private final int number;
    private final CyclicBarrier cyclicBarrier;

    public Runner(int number, CyclicBarrier cyclicBarrier) {
        this.number = number;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {

            System.out.printf("%d 号运动员入场，进行热身准备。\n", number);
            TimeUnit.SECONDS.sleep((new Random()).nextInt(5));
            System.out.printf("%d 号运动员热身完毕，在起跑线等待发令枪。\n", number);

            cyclicBarrier.await();

            System.out.printf("%d 号运动员开跑。\n", number);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
