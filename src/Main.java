import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        String taskFile = "Tests/TestCase2.txt";
        TasksReader.storeTasks(taskFile);
        Simulator simulator = new Simulator(TasksReader.tasks,4);
        simulator.start();
    }
}
