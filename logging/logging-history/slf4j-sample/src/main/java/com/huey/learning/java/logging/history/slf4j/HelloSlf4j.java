package com.huey.learning.java.logging.history.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloSlf4j {

    final static Logger logger = LoggerFactory.getLogger(HelloSlf4j.class);

    public static void main(String[] args) {
        logger.info("Hello, SLF4J!");
    }

}