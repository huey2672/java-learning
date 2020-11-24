package com.huey.learning.java.logging.logback.quickstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huey
 */
public class HelloLogback {

    final static Logger logger = LoggerFactory.getLogger(HelloLogback.class);

    public static void main(String[] args) {
        logger.info("Hello, Logback!");
    }

}
