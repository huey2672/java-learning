package com.huey.learning.java.concurrent.synchronizedkeyword;

public class ReentrantCase {

    public synchronized void methodA() {
        System.out.println("开始执行 A 方法。");
        methodB();
    }

    public synchronized void methodB() {
        System.out.println("开始执行 B 方法。");
    }

    public static void main(String[] args) {

        final ReentrantCase synchronizedObject = new ReentrantCase();
        Thread thread = new Thread(synchronizedObject::methodA);
        thread.start();

    }

}