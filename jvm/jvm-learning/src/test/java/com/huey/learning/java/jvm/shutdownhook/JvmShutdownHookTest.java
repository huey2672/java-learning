package com.huey.learning.java.jvm.shutdownhook;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * test case of jvm's shutdown hook
 *
 * @author huey
 */
public class JvmShutdownHookTest {

    @Test
    public void testAddShutdownHook() {
        Thread shutdownHook = new Thread(() -> {
            System.out.println("The JVM is shutting down.");
        });
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    @Test
    public void testRemoveShutdownHook() {
        Thread shutdownHook = new Thread(() -> {
            System.out.println("The JVM is shutting down.");
        });
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        assertTrue(Runtime.getRuntime().removeShutdownHook(shutdownHook));
    }

}
