package com.huey.learning.java.common.spi.service;

import java.util.Iterator;
import java.util.ServiceLoader;

public final class LoggerFactory {

    private LoggerFactory() {
        super();
    }

    private static ILogger logger;

    static {

        ServiceLoader<ILogger> loggerLoader = ServiceLoader.load(ILogger.class);

        Iterator<ILogger> iterator = loggerLoader.iterator();
        if (iterator.hasNext()) {
            logger = iterator.next();
        } else {
            throw new RuntimeException("Could not find any providers of the ILogger.");
        }

    }

    public static ILogger getLogger() {
        return logger;
    }

}