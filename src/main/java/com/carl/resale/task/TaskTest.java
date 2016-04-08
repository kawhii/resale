package com.carl.resale.task;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.CalendarIntervalScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.DateBuilder.*;

/**
 * @author Carl
 * @date 2016/4/8
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class TaskTest {
    public static void main(String[] args) throws Exception {
        Scheduler sched = StdSchedulerFactory.getDefaultScheduler();

        sched.start();

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(MyJob.class)
                .withIdentity("myJob", "group1")
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
    }
}
