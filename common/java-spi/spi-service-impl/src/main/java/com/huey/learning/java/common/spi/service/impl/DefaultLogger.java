package com.huey.learning.java.common.spi.service.impl;

import com.huey.learning.java.common.spi.service.ILogger;

import java.util.Date;

/**
 * @author huey
 */
public class DefaultLogger implements ILogger {

    @Override
    public void info(String message) {
        String line = String.format("[DefaultLogger] %s - %s", new Date(), message);
        System.out.println(line);
    }

}