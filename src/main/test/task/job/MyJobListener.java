package task.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.TriggerListener;
import org.quartz.listeners.JobListenerSupport;

/**
 * @author Carl
 * @date 2016/4/9
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class MyJobListener extends JobListenerSupport implements JobListener {

    private String name;

    public MyJobListener(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("jobToBeExecuted");
    }

    public void jobWasExecuted(JobExecutionContext context,
                               JobExecutionException jobException) {
        // do something with the event
        System.out.println("jobWasExecuted");
    }

    public void jobExecutionVetoed(JobExecutionContext context) {
        // do something with the event
        System.out.println("jobExecutionVetoed");
    }
}