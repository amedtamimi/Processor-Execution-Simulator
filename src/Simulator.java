import java.util.*;
public class Simulator {
   private static Queue<Task> QueueOfTasks;
   private List<Processor> processors;
   private Scheduler scheduler;

    public Simulator(List<Task> tasks, int numOfProcessors)  {
        QueueOfTasks = new PriorityQueue<>(new TaskPriorityComparator());
        QueueOfTasks.addAll(tasks);

        processors = new ArrayList<>();
        for (int i = 0; i < numOfProcessors; i++) {
            Processor processor = new Processor();
            processors.add(processor);
        }

    }

    public void  start() throws InterruptedException {
        scheduler=Scheduler.getInstance();
        scheduler.start(QueueOfTasks,this.processors);

    }

}
