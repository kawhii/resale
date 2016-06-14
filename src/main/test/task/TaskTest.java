package task;

import org.quartz.*;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import task.job.HelloJob;
import task.job.HelloJobDouble;
import task.job.MyJobListener;

import java.util.*;
import java.util.Calendar;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.impl.matchers.EverythingMatcher.allJobs;
import static org.quartz.impl.matchers.GroupMatcher.groupEquals;

/**
 * @author Carl
 * @date 2016/4/9
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class TaskTest {
    public static void main(String[] args) throws Exception {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        Set<JobKey> keys = sched.getJobKeys(GroupMatcher.anyJobGroup());
        sched.deleteJobs(new ArrayList<>(keys));
      //  sched.getListenerManager().addJobListener(new MyJobListener("myJob"), jobGroupEquals("group1"));
        sched.start();
        JobDetail job = newJob(HelloJob.class).storeDurably()
                .withIdentity("myJob1", "group1").usingJobData("key1", "value1")
                .build();

        Trigger trigger = newTrigger()
                .forJob(jobKey("myJob1", "group1"))
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(20).withRepeatCount(2))
                .build();

        sched.scheduleJob(job,trigger);

        Trigger trigger2 = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder
                .cronSchedule("0/5 * * * * ?"))
                .startNow()
                .forJob(jobKey("myJob", "group1"))
                .build();
//        sched.addJob(job, true);
//        sched.scheduleJob(job,trigger);

        Thread.sleep(1000);
        sched.triggerJob(jobKey("myJob1", "group1"));
        sched.triggerJob(jobKey("myJob1", "group1"));
        sched.triggerJob(jobKey("myJob1", "group1"));
        /*
        Thread.sleep(3 * 1000);
        sched.deleteJob(jobKey("myJob", "group1"));*/
        //sched.pauseJob(new JobKey("myJob", "group1"));
       // sched.scheduleJob(job, new HashSet<Trigger>(l), true);
        // sched.triggerJob(new JobKey("myJob", "group1"));
        //sched.deleteJob(new JobKey("myJob", "group1"));
//        CronTriggerImpl corn = new CronTriggerImpl("myTrigger", "group1", "");
    }
}
