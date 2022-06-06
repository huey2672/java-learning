package com.huey.learning.java.logging.logback.quickstart;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    final static Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void testParameterizedMessages() {
        int count = 10;
        logger.debug("Current count is " + count);
        logger.debug("Current count is {}", count);
    }

}
