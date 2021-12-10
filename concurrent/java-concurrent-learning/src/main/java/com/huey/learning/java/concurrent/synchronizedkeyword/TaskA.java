package com.huey.learning.java.concurrent.synchronizedkeyword;

public class TaskA implements Runnable {

    private final SynchronizedClass synchronizedObject;

    public TaskA(SynchronizedClass synchronizedObject) {
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
        synchronizedObject.methodA();
    }

}