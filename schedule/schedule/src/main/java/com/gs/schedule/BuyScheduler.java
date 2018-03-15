package com.gs.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author xiaopeng
 * @date 2018/3/14 10:58
 */
public class BuyScheduler {

    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            JobDataMap dataMap = new JobDataMap();
            dataMap.put("money", 100.0);
            dataMap.put("thing", "cake");
            JobDetail jobDetail = JobBuilder.newJob(BuyJob.class)
                    .withIdentity("buyJob", "group_1")
                    .setJobData(dataMap)
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("buyTrigger", "group_1")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                    .build();

            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
