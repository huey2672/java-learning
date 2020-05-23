package com.huey.learning.java.common.spi.quickstart;

import com.huey.learning.java.common.spi.service.ILogger;
import com.huey.learning.java.common.spi.service.LoggerFactory;

/**
 * @author huey
 */
public class MainApp {

    public static void main(String[] args) {

        ILogger logger = LoggerFactory.getLogger();

        logger.info("Starting the application.");

        // do something...

        logger.info("The application is exited.");

    }

}