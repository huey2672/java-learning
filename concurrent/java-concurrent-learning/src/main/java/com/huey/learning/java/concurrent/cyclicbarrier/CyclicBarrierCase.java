package com.huey.learning.java.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierCase {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("发令枪响了，跑！");
            }
        });

        for (int i = 1; i <= cyclicBarrier.getParties(); i++) {
            Thread runner = new Thread(new Runner(i, cyclicBarrier));
            runner.start();
        }

    }

}
