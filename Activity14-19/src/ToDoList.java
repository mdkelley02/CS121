import javax.swing.table.TableStringConverter;
import java.util.ArrayList;
public class ToDoList implements ToDoListInterface
{
    private String name;
    private ArrayList<Task> tasks;

    public ToDoList(String name)
    {
        this.name = name;
        this.tasks = new ArrayList<Task>();
    }


    public String toString()
    {
        String str = "-----------------\n" + this.name + "\n-----------------\n";
        for (Task t: tasks)
        {
            str = str + "\n" + t.toString();
        }
        return str;

    }
    @Override
    public String getName()
    {
        return this.name;
    }


    @Override
    public void addTask(Task task)
    {
        tasks.add(task);
    }


    @Override
    public void addTask(String description, int priority, Task.Category category)
    {
        this.tasks.add(new Task(description, priority, category));
    }


    @Override
    public Task getWork()
    {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task("placeholder", 0, Task.Category.NONE));
        for (Task t: this.tasks)
        {
            if (!t.isComplete())
            {
                if (t.getPriority() > taskList.get(0).getPriority())
                {
                    taskList.add(0, t);
                }
            }
        }
        if (taskList.get(0).getDescription().equals("placeholder"))
        {
            return null;
        }
        else
        {
            return taskList.get(0);
        }
    }

    @Override
    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }
}
