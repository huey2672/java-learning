package com.huey.learning.java.kryo.pitfall.cglibproxyobject;

public class PreGreetingAspect {

    public void beforeGreeting() {
        System.out.println("Nice to meet you.");
    }

}