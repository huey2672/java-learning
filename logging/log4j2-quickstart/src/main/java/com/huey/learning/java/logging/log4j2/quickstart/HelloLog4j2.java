package com.huey.learning.java.logging.log4j2.quickstart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloLog4j2 {

    final static Logger logger = LogManager.getLogger(HelloLog4j2.class);

    public static void main(String[] args) {
        logger.info("Hello, Log4j 2.x!");
    }

}