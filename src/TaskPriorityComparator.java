import java.util.Comparator;

class TaskPriorityComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return Integer.compare(t1.getPriority(), t2.getPriority());
    }
}