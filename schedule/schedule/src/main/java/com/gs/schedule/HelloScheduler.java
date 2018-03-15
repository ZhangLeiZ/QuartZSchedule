package com.gs.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author xiaopeng
 * @date 2018/3/14 10:45
 */
public class HelloScheduler {

    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("helloJob", "job_group")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("helloJobTrigger", "trigger_group")
                    // .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(3))
                    .build();

            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
