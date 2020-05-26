package com.huey.learning.java.quartz.calendar;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

/**
 * @author huey
 */
public class CalendarCase {

    public static void main(String[] args) throws Exception {

        // news a scheduler factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // gets a scheduler from the factory
        Scheduler scheduler = schedulerFactory.getScheduler();

        // defines the job and ties it to our HelloJob class
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", Scheduler.DEFAULT_GROUP)
                .requestRecovery()
                .build();

        // news a HolidayCalendar
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        // adds excluded date
        holidayCalendar.addExcludedDate(DateBuilder.dateOf(0, 0, 0, 25, 6, 2020));
        holidayCalendar.addExcludedDate(DateBuilder.dateOf(0, 0, 0, 1, 10, 2020));
        // registers the Calendar
        scheduler.addCalendar("myHoliday", holidayCalendar, false, true);

        // triggers the job to run now, and then fires at 9:00 every workday
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", Scheduler.DEFAULT_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0 0 9 ? * MON-FRI")))
                // associates Trigger with Holiday
                .modifiedByCalendar("myHoliday")
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
