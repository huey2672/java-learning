package com.huey.learning.java.se8.lambda;

public class ThisInLambda {

    public void doWork() {

        Runnable runner = () -> System.out.println(this.getClass().getName());
        new Thread(runner).start();

    }

    public static void main(String[] args) {
        new ThisInLambda().doWork();
    }

}