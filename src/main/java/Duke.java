import java.util.Scanner;

public class Duke {

    private Task[] list = new Task[100];
    private int count = 0;

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?\n");

        Duke myDuke = new Duke();
        Scanner input = new Scanner(System.in);
        String output = "";


        do{
            output = input.nextLine();
            try {
                myDuke.commandLine(output);
            } catch (DukeException e){
                System.out.println(e);
            }

        }while(!output.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }

    private void commandLine(String output) throws DukeException{
        int t_token, d_token, e_token;

        String[] tokens = output.split("\\s+");
        switch(tokens[0]){
            case "list":
                System.out.println("Here are the tasks in your list:");
                for(int x = 0; x < count; x++) {
                    System.out.println( (x+1) + "." + list[x].toString() );
                }
                System.out.println();
                break;
            case "bye":
                break;
            case "done":
                int item = Integer.parseInt(tokens[1]) - 1;
                list[item].markAsDone();
                System.out.println("Nice! I've marked this task as done:\n" +
                        list[item].toString() + "\n");
                break;
            case "todo":
                if (tokens.length == 1){
                    throw new DukeException("Error! todo description is empty.");
                }
                else {
                    String todo = tokens[1];
                    t_token = 2;
                    while (t_token < tokens.length) {
                        todo = todo + " " + tokens[t_token];
                        t_token++;
                    }
                    list[count] = new Todo(todo);
                    System.out.println("Got it. I've added this task:\n" +
                            "  " + list[count].toString());
                    count++;
                    System.out.println(("Now you have " + count + " tasks in the list.\n"));
                }
                break;
            case "deadline":
                String deadline = tokens[1], by = "";
                d_token = 2;
                while(d_token < tokens.length && !tokens[d_token].equals("/by")){
                    deadline = deadline + " " + tokens[d_token];
                    d_token++;
                }
                d_token++;
                by = tokens[d_token];
                d_token++;
                while(d_token < tokens.length){
                    by = by + " " + tokens[d_token];
                    d_token++;
                }

                list[count] = new Deadline(deadline, by);
                System.out.println("Got it. I've added this task:\n" +
                        "  " + list[count].toString());
                count++;
                System.out.println(("Now you have " + count + " tasks in the list.\n"));
                break;
            case "event":
                String event = tokens[1], at = "";
                e_token = 2;
                while(e_token < tokens.length && !tokens[e_token].equals("/at")){
                    event = event + " " + tokens[e_token];
                    e_token++;
                }
                e_token++;
                at = tokens[e_token];
                e_token++;
                while(e_token < tokens.length){
                    at = at + " " + tokens[e_token];
                    e_token++;
                }

                list[count] = new Event(event, at);
                System.out.println("Got it. I've added this task:\n" +
                        "  " + list[count].toString());
                count++;
                System.out.println(("Now you have " + count + " tasks in the list.\n"));
                break;
            default:
                throw new DukeException("Error! Unrecognisable command inputted");

        }

    }

}

