package com.huey.learning.java.se8.lambda;

/**
 * @author huey
 */
public class LocalVariableInLambda {

    public void doWork(int times) {

        new Thread(() -> {

            for (int i = 0; i < times; i++) {
                // ...
            }

        }).start();

    }

}
