public class Processor {
    private final int ProcessorId;
    private int usageTime=0;
    private static int ProcessorCount = 0;
    Object lock = null;
    private Task currentTask;

    public Processor() {
        ProcessorCount++;
        this.ProcessorId = ProcessorCount;
    }

    public void execute (Task task){
        if(lock == null) {
            lock = new Object();
            this.currentTask=task;
            Status.taskCreation(task.getTaskId());
        }
    }

    public void incrementUsageTime() {
        usageTime++;
        if (currentTask != null && usageTime >= currentTask.getExecutionTime()) {
            Status.finishedTask(this.ProcessorId, currentTask.getTaskId());
            lock = null;
            usageTime = 0;
        }
    }


    public boolean isFree(){
        return lock == null;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

}
