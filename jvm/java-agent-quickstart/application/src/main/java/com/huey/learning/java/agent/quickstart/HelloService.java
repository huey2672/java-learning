package com.huey.learning.java.agent.quickstart;

import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class HelloService {

    public void sayHello() throws Exception {
        System.out.println("Hello, World!");
        TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
    }

}
