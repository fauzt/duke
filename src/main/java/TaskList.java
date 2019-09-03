import java.util.ArrayList;

public class TaskList {

    protected ArrayList<Task> list;

    public TaskList(){
        list = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> list){
        this.list = list;
    }

    public void addTask(Task t){

        list.add(t);
        System.out.println("Got it. I've added this task:\n" +
                "  " + t.toString());
        System.out.println(("Now you have " + list.size() + " tasks in the list.\n"));


    }

    public void deleteTask(int del){
        //int del = Integer.parseInt(tokens[1]) - 1;

        System.out.println("Noted. I removed this task:\n" +
                list.get(del).toString());
        list.remove(del);
        System.out.println(("Now you have " + list.size() + " tasks in the list"));
        System.out.println();
    }

    public void showList(){
        System.out.println("Here are the tasks in your list:");
        for(int x = 0; x < list.size(); x++) {
            System.out.println( (x+1) + "." + list.get(x).toString() );
        }
        System.out.println();
    }

    public void markDone(int item){
        //int item = Integer.parseInt(tokens[1]) - 1;

        list.get(item).markAsDone();
        System.out.println("Nice! I've marked this task as done:\n" +
                list.get(item).toString() + "\n");

    }

    public void findTasks(String find){
        //String f = output.replaceFirst("find ", "");

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
