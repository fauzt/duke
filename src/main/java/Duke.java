/**
 * The main class of the Duke program.
 * Initialise a task list manager for the user to manage their individual tasks.
 *
 * @author Fauzan Adipratama
 * @version 1.0
 */


public class Duke {

    private Ui ui;
    private DukeStorage storage;
    private TaskList tasks;

    /**
     * Constructor used to initialise the necessary functions of Duke.
     * @param filepath This is the file directory path that Duke will read and save the task list data.
     */

    public Duke(String filepath){
        ui = new Ui();
        storage = new DukeStorage(filepath);
        try {
            tasks = new TaskList(storage.readFile());
        } catch(DukeException e) {
            tasks = new TaskList();
        }
    }

    public static void main(String[] args) {
        new Duke("data/list.ser").run();
        }

    /**
     * The main execution method while Duke runs.
     */

    private void run(){
        ui.welcomeMessage();
        String output = "";
        do{
            output = ui.read();
            try {
                Parser.parse(output, tasks);
            } catch (DukeException e){
                System.out.println(e);
            }
        }while(!output.equals("bye"));

        try {
            DukeStorage.writeFile(tasks.list);
        } catch(DukeException e){
            System.out.println(e);
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}


