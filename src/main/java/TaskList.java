import java.util.ArrayList;

/**
 * This class handles all operations to the data such as adding new data, finding data etc.
 */

public class TaskList {

    protected ArrayList<Task> list;

    /**
     * This constructor initialise the data structure to store the task list data.
     */

    public TaskList(){
        list = new ArrayList<Task>();
    }

    /**
     * This constructor loads the data found in the data storage file into Duke.
     * @param list This is the data read from the file to be loaded into Duke
     */

    public TaskList(ArrayList<Task> list){
        this.list = list;
    }

    /**
     * This method adds a new task into the task list.
     * @param t This is the task object to be added into the data structure.
     */

    public void addTask(Task t){
        list.add(t);
        System.out.println("Got it. I've added this task:\n" +
                "  " + t.toString());
        System.out.println(("Now you have " + list.size() + " tasks in the list.\n"));
    }

    /**
     * This method deletes the chosen task in the task list from Duke.
     * @param del This is the index number of task that the user wish to delete.
     */

    public void deleteTask(int del){
        System.out.println("Noted. I removed this task:\n" +
                list.get(del).toString());
        list.remove(del);
        System.out.println(("Now you have " + list.size() + " tasks in the list"));
        System.out.println();
    }

    /**
     * This method displays the task list to the user in the UI.
     */

    public void showList(){
        System.out.println("Here are the tasks in your list:");
        for(int x = 0; x < list.size(); x++) {
            System.out.println( (x+1) + "." + list.get(x).toString() );
        }
        System.out.println();
    }

    /**
     * This method marks the chosen task as done.
     * @param item This is the index number of the task in the list that the user wish to mark as done.
     */

    public void markDone(int item){
        list.get(item).markAsDone();
        System.out.println("Nice! I've marked this task as done:\n" +
                list.get(item).toString() + "\n");
    }

    /**
     * This method finds the tasks with the description that matches the user-inputted terms
     * @param find This is the search term that the user wish to find in the task list.
     */

    public void findTasks(String find){
        int count = 0;

        System.out.println("Here are the matching tasks in your list:");
        for (int x = 0; x < list.size(); x++){
            if (list.get(x).description.contains(find)){
                count++;
                System.out.println(count + "." + list.get(x).toString());
            }
        }
        System.out.println();
    }

}
