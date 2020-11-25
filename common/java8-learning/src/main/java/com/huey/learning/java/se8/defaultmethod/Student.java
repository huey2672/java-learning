package com.huey.learning.java.se8.defaultmethod;

public class Student implements Person, Named {

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return Person.super.getName();
    }

}