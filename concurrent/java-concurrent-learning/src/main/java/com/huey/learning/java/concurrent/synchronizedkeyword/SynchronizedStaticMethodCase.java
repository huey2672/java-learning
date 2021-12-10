package com.huey.learning.java.concurrent.synchronizedkeyword;

import java.util.Date;

public class SynchronizedStaticMethodCase {

    public synchronized static void methodA() {
        System.out.println("开始执行 A 方法。" + new Date());
        try {
            Thread.sleep(3000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束执行 A 方法。" + new Date());
    }

    public synchronized static void methodB() {
        System.out.println("开始执行 B 方法。" + new Date());
        try {
            Thread.sleep(3000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束执行 B 方法。" + new Date());
    }

    public static void main(String[] args) {

        Thread threadA = new Thread(SynchronizedStaticMethodCase::methodA);
        Thread threadB = new Thread(SynchronizedStaticMethodCase::methodB);

        threadA.start();
        threadB.start();

    }

}