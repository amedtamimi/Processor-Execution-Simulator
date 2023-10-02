import java.util.ArrayList;
import java.util.List;

public class Clock {
    private final int clockId;
    private final List<Task> tasks;
    private static int ClockCount=0;

    public Clock() {
        ClockCount++;
        tasks= new ArrayList<>();
        this.clockId=ClockCount;
    }

    public int getClockId() {
        return clockId;
    }

    public void setTaskList(Task task) {
        this.tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
