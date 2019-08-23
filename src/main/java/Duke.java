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
        String[] list = new String[100];
        int x = 0;
        int count = 0;

        do{
            output = input.nextLine();
            if (output.equals("list")){
                while(x < count) {
                    System.out.println( (x+1) + ". " + list[x]);
                    x++;
                }
                x = 0;
            }
            else if (!output.equals("bye")) {
                System.out.println("added: " + output + "\n");
                list[count] = output;
                count++;
            }
            else{
                break;
            }
        }while(!output.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }
}

