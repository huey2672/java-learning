package com.huey.learning.java.quartz.joblistener;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

/**
 * @author huey
 */
public class JobListenerCase {

    public static void main(String[] args) throws Exception {

        // news a scheduler factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // gets a scheduler from the factory
        Scheduler scheduler = schedulerFactory.getScheduler();

        // registers a job listener
        JobListener myJobListener = new MyJobListener("myJobListener");
        scheduler.getListenerManager().addJobListener(myJobListener, GroupMatcher.jobGroupEquals(Scheduler.DEFAULT_GROUP));

        // defines the job and ties it to our HelloJob class
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", Scheduler.DEFAULT_GROUP)
                .requestRecovery()
                .build();

        // triggers the job to run now, and then every 10 seconds
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", Scheduler.DEFAULT_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0/10 * * * * ?")))
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
