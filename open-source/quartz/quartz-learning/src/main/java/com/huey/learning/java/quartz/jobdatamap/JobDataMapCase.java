package com.huey.learning.java.quartz.jobdatamap;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author huey
 */
public class JobDataMapCase {

    public static void main(String[] args) throws Exception {

        // news a scheduler factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // gets a scheduler from the factory
        Scheduler scheduler = schedulerFactory.getScheduler();

        // defines the job and ties it to our HelloJob class
        JobDetail jobDetail = JobBuilder.newJob(HelloJobV2.class)
                .withIdentity("myJob", Scheduler.DEFAULT_GROUP)
                .usingJobData(HelloJob.KEY_QUARTZ_VERSION, "2.2.2")
                .requestRecovery()
                .build();

        // triggers the job to run now, and then every 5 seconds
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", Scheduler.DEFAULT_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0/5 * * * * ?")))
                .build();

        // tells quartz to schedule the job using our trigger
        scheduler.scheduleJob(jobDetail, trigger);

        // starts the scheduler
        scheduler.start();

        // pause
        System.in.read();

        // shuts the scheduler down
        scheduler.shutdown(true);

    }

}
