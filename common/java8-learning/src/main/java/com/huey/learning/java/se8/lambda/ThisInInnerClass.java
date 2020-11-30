package com.huey.learning.java.se8.lambda;

public class ThisInInnerClass {

    public void doWork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        }).start();
    }

    public static void main(String[] args) {
        new ThisInInnerClass().doWork();
    }

}