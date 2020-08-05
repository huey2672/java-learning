package com.huey.learning.java.exception.classnotfoundexception;

import org.junit.Test;

/**
 * @author huey
 */
public class ClassNotFoundExceptionTest {

    @Test(expected = ClassNotFoundException.class)
    public void testClassNotFoundExceptionOccurrence() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

}
