package com.huey.learning.java.concurrent.synchronizedkeyword;

import java.util.Date;

public class SynchronizedClass {

    public void methodA() {
        System.out.println("开始执行 A 方法。" + new Date());
        synchronized (this) {
            System.out.println("进入 A 方法的临界区。" + new Date());
            try {
                Thread.sleep(3000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("离开 A 方法的临界区。" + new Date());
        }
        System.out.println("结束执行 A 方法。" + new Date());
    }

    public void methodB() {
        System.out.println("开始执行 B 方法。" + new Date());
        synchronized (this) {
            System.out.println("进入 B 方法的临界区。" + new Date());
            try {
                Thread.sleep(3000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("离开 B 方法的临界区。" + new Date());
        }
        System.out.println("结束执行 B 方法。" + new Date());
    }

}