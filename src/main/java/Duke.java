import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?\n");

        Scanner input = new Scanner(System.in);
        String output = "";
        Task[] list = new Task[100];
        int x = 0, count = 0;


        loop: do{
            output = input.nextLine();
            String[] tokens = output.split("\\s+");
            switch(tokens[0]){
                case "list":
                    System.out.println("Here are the tasks in your list:");
                    while(x < count) {
                        System.out.println( (x+1) + ".[" + list[x].getStatus() + "] " + list[x].description);
                        x++;
                    }
                    System.out.println("\n");
                    x = 0;
                    break;
                case "bye":
                    break loop;
                case "done":
                    int item = Integer.parseInt(tokens[1]) - 1;
                    list[item].markAsDone();
                    System.out.println("Nice! I've marked this task as done:\n" +
                            "[" + list[item].getStatus() + "] " + list[item].description + "\n");
                    break;
                default:
                    System.out.println("added: " + output + "\n");
                    Task t = new Task(output);
                    list[count] = t;
                    count++;

            }
        }while(!output.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }
}

