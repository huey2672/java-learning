package com.huey.learning.java.concurrent.synchronizedkeyword;

public class TaskB implements Runnable {

    private final SynchronizedClass synchronizedObject;
    
    public TaskB(SynchronizedClass synchronizedObject) {
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
		synchronizedObject.methodB();
    }

}