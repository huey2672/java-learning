package com.huey.learning.java.concurrent.thread.interruption;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * This class searches for files with a name in a directory
 *
 * @author huey
 */
public class FileSearcher implements Runnable {

    /**
     * initial path for the search
     */
    private String initPath;
    /**
     * name of the file we are searching for
     */
    private String fileName;

    public FileSearcher(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted.", Thread.currentThread().getName());
            }
        }

    }

    /**
     * processes a directory
     *
     * @param directory
     * @throws InterruptedException
     */
    private void directoryProcess(File directory) throws InterruptedException {

        // gets the content of the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If is a directory, process it
                    directoryProcess(file);
                } else {
                    // If is a file, process it
                    fileProcess(file);
                }
            }
        }

        // checks the interruption
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }

    }

    /**
     * processes a File
     *
     * @param file
     * @throws InterruptedException
     */
    private void fileProcess(File file) throws InterruptedException {

        // checks the file name
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }

        // checks the interruption
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }

    }

}