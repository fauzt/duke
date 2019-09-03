
public class Duke {

    private Ui ui;
    private DukeStorage storage;
    private TaskList tasks;

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
        new Duke("/data/list.ser").run();

        }

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


