package task;

import org.quartz.*;
import task.job.HelloJob;
import task.job.HelloJobDouble;
import task.job.MyJobListener;
import task.job.MyTriggerListener;

import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.impl.matchers.EverythingMatcher.allTriggers;
import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals;

/**
 * @author Carl
 * @date 2016/4/10
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class TaskTrgLisTest {
    public static void main(String[] args)  throws  Exception {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        MyTriggerListener myTriggerListener = new MyTriggerListener("tg");
        sched.getListenerManager().addTriggerListener(myTriggerListener, allTriggers());
       // sched.getListenerManager().addJobListener(new MyJobListener("myJob"), jobGroupEquals("group1"));
        sched.start();

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);


    }
}
