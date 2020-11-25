package com.huey.learning.java.se8.defaultmethod;

public interface Named {

    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }

}