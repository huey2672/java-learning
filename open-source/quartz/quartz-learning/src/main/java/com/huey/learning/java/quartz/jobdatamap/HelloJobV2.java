package com.huey.learning.java.quartz.jobdatamap;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author huey
 */
public class HelloJobV2 implements Job {

    @lombok.Setter
    private String quartzVersion;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.printf("Our quartz's version is %s.\n", quartzVersion);
    }

}
