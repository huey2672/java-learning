package com.huey.learning.java.quartz.schedulerlistener;

import org.quartz.listeners.SchedulerListenerSupport;

/**
 * @author huey
 */
public class MySchedulerListener extends SchedulerListenerSupport {

    @Override
    public void schedulerStarting() {
        System.out.println("The scheduler is starting.");
    }

    @Override
    public void schedulerStarted() {
        System.out.println("The scheduler is started.");
    }

}
