package com.huey.learning.java.quartz.jobdatamap;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    public final static String KEY_QUARTZ_VERSION = "quartzVersion";

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String quartzVersion = context.getJobDetail().getJobDataMap().getString(KEY_QUARTZ_VERSION);
        System.out.printf("Our quartz's version is %s.\n", quartzVersion);
    }

}