package task.job;

/**
 * @author Carl
 * @date 2016/4/10
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.listeners.SchedulerListenerSupport;

public class MyTriggerListener implements TriggerListener {

    private String name;

    public MyTriggerListener(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void triggerComplete(Trigger trigger, JobExecutionContext context,
                                CompletedExecutionInstruction triggerInstructionCode) {
        System.out.println("triggerComplete");

    }

    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        // do something with the event
        System.out.println("triggerFired");
    }

    public void triggerMisfired(Trigger trigger) {
        // do something with the event
        System.out.println("triggerMisfired");
    }

    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        // do something with the event
        System.out.println("vetoJobExecution");
        return false;
    }

}
