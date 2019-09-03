import java.util.Scanner;

public class Ui {

    Scanner input;

    public Ui(){
        this.input = new Scanner(System.in);
    }

    public String read(){
        return input.nextLine();
    }

    public void welcomeMessage(){

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?\n");
    }

}
