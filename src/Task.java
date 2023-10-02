public class Task {
    private final int taskId;
    private final int creationTime;
    private final int executionTime;
    private final int priority;
    private static int taskCount = 0;

    public Task(int creationTime, int executionTime, int priority) {
        taskCount++;
        this.taskId = taskCount;
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getCreationTime() {
        return creationTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getPriority() {
        return priority;
    }

}

