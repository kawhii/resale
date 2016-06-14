package task.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.beans.Introspector;
import java.util.Map;

/**
 * @author Carl
 * @date 2016/4/9
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Map<String, Object> s = jobExecutionContext.getMergedJobDataMap();
        System.out.println("HelloJob working");
        jobExecutionContext.setResult("123");
    }
}
