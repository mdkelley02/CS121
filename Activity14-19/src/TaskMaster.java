public class TaskMaster {
    public static void main(String[] args)
    {
        //create and print task 1
        Task task1 = new Task("feed the dog", 5, Task.Category.WORK);
        System.out.println("Task 1");
        System.out.println(task1.toString());
        task1.setComplete(true);
        System.out.println("Task 1 is complete: true");
        System.out.println(task1.toString() + "\n");

        //create and print task 2
        Task task2 = new Task("Give tigger a bath", 10, Task.Category.WORK);
        System.out.println("Task 2");
        System.out.println(task2.toString());
        task2.setPriority(20);
        System.out.println("Task 2 priority: 20");
        System.out.println(task2.toString() + "\n");

        //create task 3
        System.out.println("Task 3");
        Task task3 = new Task("Feed the dog", 3, Task.Category.PERSONAL);

        //check if the tasks are equal
        System.out.println("Checking if Task 1 and Task 3 are equal...");
        if (task1.equals(task3))
        {
            System.out.println("task1 and task3 are equal\n");
        }
        else
        {
            System.out.println("task1 does not equal task3\n");
        }

        //check importance
        System.out.println("Comparing Task 1 and Task 2...");
        if ( task1.compareTo(task2) < 0 )
        {
            System.out.println("Task 1 is less important than Task 2");
        }
        else if (task1.compareTo(task2) > 0 )
        {
            System.out.println("Task 1 is more important than Task 2");
        }
        else
        {
            System.out.println("Task 1 and Task 2 are equally important");
        }
        ToDoList td1 = new ToDoList("Things to do today.");
        td1.addTask(task1);
        td1.addTask(task2);
        td1.addTask(task3);
        td1.addTask(new Task("test_decription", 5, Task.Category.PERSONAL));
        System.out.println(td1.toString());
        System.out.println("\n"+td1.getWork());
        System.out.println();

    }
}
