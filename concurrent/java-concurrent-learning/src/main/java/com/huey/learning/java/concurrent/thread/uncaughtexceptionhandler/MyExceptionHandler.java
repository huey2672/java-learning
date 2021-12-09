package com.huey.learning.java.concurrent.thread.uncaughtexceptionhandler;

/**
 * @author huey
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("线程 [%s] 抛出 %s 异常。异常信息：%s\n", t.getName(), e.getClass().getName(), e.getMessage());
    }

}
