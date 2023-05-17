package com.huey.learning.java.feature.java9;

public interface MyPrivateMethodInInterface {

    private void privateMethod() {
        System.out.println("This is a private inter");
    }

    default void defaultMethod() {
        System.out.println("This is a default inter");
        this.privateMethod();
    }

    private static void privateStaticMethod() {
        System.out.println("This is a private static inter");
    }

    static void staticMethod() {
        System.out.println("This is a static inter");
        privateStaticMethod();
    }

}
