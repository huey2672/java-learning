package com.huey.learning.java.exception.suppressed;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * @author huey
 */
public class SuppressedExceptionTest {

    @Test(expected = FileNotFoundException.class)
    public void testOrdinaryExceptionDemo() throws Exception {
        String filePath = "/non-existent-path/non-existent-file.txt";
        new SuppressedExceptionSample().demoOrdinaryException(filePath);
    }

    @Test(expected = NullPointerException.class)
    public void testSuppressedExceptionDemo() throws Exception {
        String filePath = "/non-existent-path/non-existent-file.txt";
        new SuppressedExceptionSample().demoSuppressedException(filePath);
    }

    @Test
    public void testSuppressedExceptionInTryWithResourcesDemo() throws Exception {

        try {
            new SuppressedExceptionSample().demoSuppressedExceptionInTryWithResources();
        }
        catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
            Assert.assertEquals("Thrown from execute()", e.getMessage());

            Assert.assertEquals(1, e.getSuppressed().length);
            Assert.assertTrue(e.getSuppressed()[0] instanceof IllegalStateException);
            Assert.assertEquals("Thrown from close()", e.getSuppressed()[0].getMessage());
        }

    }

}
