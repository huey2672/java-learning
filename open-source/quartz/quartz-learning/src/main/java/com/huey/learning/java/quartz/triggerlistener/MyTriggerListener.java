package com.huey.learning.java.quartz.triggerlistener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.listeners.TriggerListenerSupport;

/**
 * @author huey
 */
public class MyTriggerListener extends TriggerListenerSupport {

    private String name;

    public MyTriggerListener(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        System.out.printf("The trigger [%s] is fired.\n", trigger.getKey().getName());
    }

}
