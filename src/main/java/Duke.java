import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private ArrayList<Task> list;

    public Duke(){
        this.list = new ArrayList<Task>();
    }

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

        try {
            ArrayList<Task> temp = DukeStorage.readFile();
            if (temp != null){
                myDuke.list = temp;
            }
        } catch (DukeException e){
            System.out.println(e);
        }

        do{
            output = input.nextLine();
            try {
                myDuke.commandLine(output);
            } catch (DukeException e){
                System.out.println(e);
            }

        }while(!output.equals("bye"));

        try {
            DukeStorage.writeFile(myDuke.list);
        } catch(DukeException e){
            System.out.println(e);
        }

        System.out.println("Bye. Hope to see you again soon!");
    }

    private void commandLine(String output) throws DukeException{
        int t_token, d_token, e_token;

        String[] tokens = output.split("\\s+");
        switch(tokens[0]){
            case "list":
                System.out.println("Here are the tasks in your list:");
                for(int x = 0; x < list.size(); x++) {
                    System.out.println( (x+1) + "." + list.get(x).toString() );
                }
                System.out.println();
                break;
            case "bye":
                break;
            case "done":
                int item = Integer.parseInt(tokens[1]) - 1;
                list.get(item).markAsDone();
                System.out.println("Nice! I've marked this task as done:\n" +
                        list.get(item).toString() + "\n");
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
                    Task t = new Todo(todo);
                    list.add(t);
                    System.out.println("Got it. I've added this task:\n" +
                            "  " + t.toString());
                    System.out.println(("Now you have " + list.size() + " tasks in the list.\n"));
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

                if (by.contains("/")){
                    by = DateFormatter.formatDate(by);
                }

                Task d = new Deadline(deadline, by);
                list.add(d);
                System.out.println("Got it. I've added this task:\n" +
                        "  " + d.toString());
                System.out.println(("Now you have " + list.size() + " tasks in the list.\n"));
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

                if (at.contains("/")){
                    at = DateFormatter.formatDate(at);
                }

                Task e = new Event(event, at);
                list.add(e);
                System.out.println("Got it. I've added this task:\n" +
                        "  " + e.toString());
                System.out.println(("Now you have " + list.size() + " tasks in the list.\n"));
                break;
            case "delete":
                int del = Integer.parseInt(tokens[1]) - 1;

                System.out.println("Noted. I removed this task:\n" +
                        list.get(del).toString());
                list.remove(del);
                System.out.println(("Now you have " + list.size() + " tasks in the list"));
		break;

            case "find":
                String f = output.replaceFirst("find ", "");
                int count = 0;

                System.out.println("Here are the matching tasks in your list:");
                for (int x = 0; x < list.size(); x++){
                    if (list.get(x).description.contains(f)){
                        count++;
                        System.out.println(count + "." + list.get(x).toString());
                    }
                }
                break;
            default:
                throw new DukeException("Error! Unrecognisable command inputted");

        }

    }

}

