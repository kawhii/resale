package task;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Carl
 * @date 2016/4/10
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class TaskProperties {
    public static void main(String[] args) throws SchedulerException {
        String schedulerProperties = "quartz/quartz.properties";
        StdSchedulerFactory sf = new StdSchedulerFactory();

        sf.initialize(schedulerProperties);

        Scheduler scheduler = sf.getScheduler();

// Scheduler will not execute jobs until it has been started (though they can be scheduled before start())
        scheduler.start();
    }
}
