package com.huey.learning.java.se8.defaultmethod;

public interface Person {

    long getId();

    default String getName() {
        return "Huey";
    }

}