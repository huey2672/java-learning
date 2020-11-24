package com.huey.learning.java.logging.history.log4j;

import org.apache.log4j.Logger;

/**
 * @author huey
 */
public class HelloLog4j {

    private static final Logger logger = Logger.getLogger(HelloLog4j.class);

    public static void main(String[] args) {
        logger.info("Hello, Log4j!");
    }

}