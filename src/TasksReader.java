import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class TasksReader {

    static ArrayList<Task> tasks= new ArrayList<>();

    public static void storeTasks(String taskFile) throws FileNotFoundException {
        File file = new File(taskFile);
        Scanner s=new Scanner(file);
        int tasksCount=Integer.parseInt(s.nextLine());
        for(int i=0;i<tasksCount;i++){
            Task task=new Task(s.nextInt(),s.nextInt(),s.nextInt());

            tasks.add(task);
            tasks.sort(new TaskComparator());



        }
    }
}
