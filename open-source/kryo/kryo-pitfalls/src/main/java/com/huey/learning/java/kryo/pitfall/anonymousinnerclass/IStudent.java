package com.huey.learning.java.kryo.pitfall.anonymousinnerclass;

public abstract class IStudent {

    private String name;

    IStudent() {

    }

    public IStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
