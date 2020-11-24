package com.huey.learning.java.logging.log4j.quickstart;

import org.apache.log4j.Logger;

public class HelloLog4j {

    static final Logger logger = Logger.getLogger(HelloLog4j.class);

    public static void main(String[] args) {
        logger.info("Hello, Log4j!");
    }

}