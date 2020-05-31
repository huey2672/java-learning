package com.huey.learning.java.quartz.quickstart;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String now = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.printf("Hello, Quartz Scheduler! It's %s now.\n", now);
    }

}
