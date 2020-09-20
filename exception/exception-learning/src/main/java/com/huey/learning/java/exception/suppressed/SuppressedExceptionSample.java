package com.huey.learning.java.exception.suppressed;

import java.io.FileInputStream;

/**
 * @author huey
 */
public class SuppressedExceptionSample {

    /**
     * demonstrate a sample of ordinary exception
     *
     * @param filePath
     * @throws Exception
     */
    public void demoOrdinaryException(String filePath) throws Exception {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        }
        finally {
            // do noting
        }
    }

    /**
     * demonstrate a sample of suppressed exception
     *
     * @param filePath
     * @throws Exception
     */
    public void demoSuppressedException(String filePath) throws Exception {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        }
        finally {
            fis.close();
        }
    }

    /**
     * @throws Exception
     */
    public void demoSuppressedExceptionInTryWithResources() throws Exception {

        try (ExceptionalResource er = new ExceptionalResource()) {
            er.execute();
        }

    }

}
