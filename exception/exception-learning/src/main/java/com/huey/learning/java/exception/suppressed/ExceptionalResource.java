package com.huey.learning.java.exception.suppressed;

/**
 * @author huey
 */
public class ExceptionalResource implements AutoCloseable {

    public void execute() {
        throw new IllegalArgumentException("Thrown from execute()");
    }

    @Override
    public void close() {
        throw new IllegalStateException("Thrown from close()");
    }

}
