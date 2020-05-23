package com.huey.learning.java.common.spi.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

import com.huey.learning.java.common.spi.service.ILogger;
import org.apache.commons.io.FileUtils;

/**
 * @author huey
 */
public class FileLogger implements ILogger {

    private File logFile;

    public FileLogger() {
        String logFilePath = System.getProperty("logging.file", "./logs/app.log");
        logFile = new File(logFilePath);
    }

    @Override
    public void info(String message) {
        try {
            String line = String.format("[FileLogger] %s - %s", new Date(), message);
            FileUtils.writeStringToFile(logFile, line + System.lineSeparator(), Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}