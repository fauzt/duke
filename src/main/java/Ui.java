import java.util.Scanner;

/**
 * This class handles all the UI functions of Duke by displaying messages and reading the user inputs.
 */

public class Ui {

    Scanner input;

    /**
     * This constructor initialises the scanner to read the user's inputs
     */

    public Ui(){
        this.input = new Scanner(System.in);
    }

    /**
     * This method reads the user's inputs and convert it into a String to be read and manipulated.
     * @return The method returns a string for the Parser class to make sense of.
     */

    public String read(){
        return input.nextLine();
    }

    /**
     * This method display the standard welcome message.
     */

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
