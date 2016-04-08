package com.carl.resale.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Carl
 * @date 2016/4/8
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("this is working");
    }
}
