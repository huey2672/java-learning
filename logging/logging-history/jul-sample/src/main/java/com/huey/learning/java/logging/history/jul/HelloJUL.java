package com.huey.learning.java.logging.history.jul;

import java.util.logging.Logger;

public class HelloJUL {

    static final Logger logger = Logger.getLogger(HelloJUL.class.getName());

    public static void main(String[] args) {
        logger.info("Hello, JUL!");
    }

}