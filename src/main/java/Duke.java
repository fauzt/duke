import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Scanner input = new Scanner(System.in);
        String output = "";

        do{
            output = input.nextLine();
            if (!output.equals("bye")) {
                System.out.println(output);
            }
            else{
                break;
            }
        }while(!output.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }
}

