package com.huey.learning.java.exception.noclassdeffounderror;

import org.junit.Test;

/**
 * @author huey
 */
public class NoClassDefFoundErrorTest {

    @Test(expected = NoClassDefFoundError.class)
    public void testNoClassDefFoundErrorOccurrence() {

        ClassWithInitErrors test;

        try {
            test = new ClassWithInitErrors();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        test = new ClassWithInitErrors();

    }

}
