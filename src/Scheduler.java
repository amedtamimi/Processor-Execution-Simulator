
import java.util.*;

public class Scheduler  {
    private static final Scheduler INSTANCE = new Scheduler();
    private Scheduler() {
    }

    public static Scheduler getInstance() {
        return INSTANCE;
    }

    private boolean isAllProcessorsFree(List<Processor> processors) {
        for (Processor processor : processors) {
            if (!processor.isFree())
                return false;
        }
        return true;

    }
    private Task getNextTask(Queue<Task> waitingQueue, Clock clock) {
        Task task = null;

        for (Task t : waitingQueue) {
            if (t.getCreationTime() <= clock.getClockId()) {
                if (task == null) {
                    task = t;
                } else {
                    if (task.getPriority() < t.getPriority()) {
                        task = t;
                    }

                    if (task.getPriority() == t.getPriority()) {
                        if (task.getExecutionTime() < t.getExecutionTime()) {
                            task = t;
                        }
                    }
                }
            }
        }

        return task;
    }

    private void decrementProcessorUsageTime(List<Processor> processors, Clock clock) {
        for (Processor processor : processors) {
            if (!processor.isFree()) {
                processor.incrementUsageTime();
                clock.setTaskList(processor.getCurrentTask());
            }
        }
    }

    private void assignTaskToFreeProcessor(Queue<Task> waitingQueue, Task task, List<Processor> processors) {
        Iterator<Task> iterator = waitingQueue.iterator();
        int freeProcessors = processors.size();

        while (iterator.hasNext()) {
            Task otherTask = iterator.next();

            if ( task.getTaskId() == otherTask.getTaskId()) {
                for (Processor processor : processors) {
                    if (processor.isFree() && freeProcessors > 0) {
                        processor.execute(task);
                        iterator.remove();
                        freeProcessors--;
                        break;
                    }
                }
            }
        }
    }

    private void executeNextTask(Queue<Task> waitingQueue, Clock clock, List<Processor> processors) {
        Task task = getNextTask(waitingQueue, clock);
        if (task == null) {
            return;
        }
        assignTaskToFreeProcessor(waitingQueue, task, processors);
    }


    private void assignTask(Queue<Task> waitingQueue, List<Processor> processors)  {
        try {
            while (!waitingQueue.isEmpty() || !isAllProcessorsFree(processors)) {
                Clock cycle = new Clock();

                Status.currentCycle(cycle.getClockId());

                int numOfProcesses = processors.size();
                while (numOfProcesses > 0) {
                    executeNextTask(waitingQueue, cycle, processors);
                    numOfProcesses--;
                }
                decrementProcessorUsageTime(processors, cycle);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Scheduler was interrupted");
        }
    }

    public void start(Queue<Task> waitingQueue, List<Processor> processors) {
        assignTask(waitingQueue, processors);
    }


}