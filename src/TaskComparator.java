import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getCreationTime() != o2.getCreationTime()) {
            return Integer.compare(o1.getCreationTime(), o2.getCreationTime());
        } else if (o1.getPriority() != o2.getPriority()) {
            return Integer.compare(o2.getPriority(), o1.getPriority());
        } else {
            return Integer.compare(o2.getExecutionTime(), o1.getExecutionTime());
        }
    }
}
