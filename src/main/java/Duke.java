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
                        System.out.println( (x+1) + "." + list[x].toString() );
                        x++;
                    }
                    System.out.println();
                    x = 0;
                    break;
                case "bye":
                    break loop;
                case "done":
                    int item = Integer.parseInt(tokens[1]) - 1;
                    list[item].markAsDone();
                    System.out.println("Nice! I've marked this task as done:\n" +
                            list[item].toString() + "\n");
                    break;
                case "todo":
                    output = output.replace("todo ", "");
                    list[count] = new Todo(output);
                    System.out.println("Got it. I've added this task:\n" +
                            "  " + list[count].toString());
                    count++;
                    System.out.println(("Now you have " + count + " tasks in the list.\n"));
                    break;
                case "deadline":
                    String deadline = "", by = "";
                    output = output.replace("deadline ", "");
                    Scanner d = new Scanner(output);
                    d.useDelimiter(" /by ");
                    deadline = d.next();
                    d.skip(" /by ");
                    by = d.nextLine();

                    list[count] = new Deadline(deadline, by);
                    System.out.println("Got it. I've added this task:\n" +
                            "  " + list[count].toString());
                    count++;
                    System.out.println(("Now you have " + count + " tasks in the list.\n"));
                    break;
                case "event":
                    String event = "", at ="";
                    output = output.replace("event ", "");
                    Scanner e = new Scanner(output);
                    e.useDelimiter(" /at ");
                    event = e.next();
                    e.skip(" /at ");
                    at = e.nextLine();

                    list[count] = new Event(event, at);
                    System.out.println("Got it. I've added this task:\n" +
                            "  " + list[count].toString());
                    count++;
                    System.out.println(("Now you have " + count + " tasks in the list.\n"));
                    break;
                default:

            }
        }while(!output.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }
}

