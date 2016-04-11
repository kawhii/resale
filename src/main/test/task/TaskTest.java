package task;

import org.quartz.*;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import task.job.HelloJob;
import task.job.HelloJobDouble;
import task.job.MyJobListener;

import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.impl.matchers.EverythingMatcher.allJobs;
import static org.quartz.impl.matchers.GroupMatcher.groupEquals;
import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals;

/**
 * @author Carl
 * @date 2016/4/9
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class TaskTest {
    public static void main(String[] args) throws Exception {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        sched.getListenerManager().addJobListener(new MyJobListener("myJob"), jobGroupEquals("group1"));
        sched.start();

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger2 = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder
                .cronSchedule("*/5 * 10 * * ? 2016"))
                .startNow()
                .forJob(jobKey("myJob2", "group2"))
                .build();
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();
        JobDetail job2 = newJob(HelloJobDouble.class)
                .withIdentity("myJob2", "group2")
                .storeDurably()
                .build();
        sched.addJob(job2, true);
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        Thread.sleep(3 * 1000);
        sched.scheduleJob(trigger2);
        sched.triggerJob(new JobKey("myJob", "group1"));

        List<Trigger> jobTriggers = (List<Trigger>) sched.getTriggersOfJob(jobKey("myJob", "group1"));
        for(Trigger t : jobTriggers) {
            System.out.println(t.getKey().getName() + "------");
            System.out.println(t.getKey().getGroup());
        }
       // sched.triggerJob(new JobKey("myJob", "group1"));
        //sched.deleteJob(new JobKey("myJob", "group1"));
//        CronTriggerImpl corn = new CronTriggerImpl("myTrigger", "group1", "");
      }
}
