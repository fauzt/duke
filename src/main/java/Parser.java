/**
 * This class handles the parsing operations of Duke and make sense of the user inputs.
 * It will then execute the associated commands and return a display message back to the user.
 */


public class Parser {

    /**
     * This method parse the inputted string into information that Duke can understand
     * so it can executes the appropriate function.
     * @param s This is the string that the user has typed into the CLI.
     * @param tasks This is the data to be manipulated by the user commands.
     * @throws DukeException
     */

    public static void parse(String s, TaskList tasks) throws DukeException{
        String[] tokens = s.split("\\s+");

        switch(tokens[0]){
            case "list":
                tasks.showList();
                break;
            case "bye":
                break;
            case "done":
                tasks.markDone( Integer.parseInt(tokens[1]) - 1 );
                break;
            case "todo":
                if (tokens.length == 1){
                    throw new DukeException("Error! todo description is empty.");
                }
                else {
                    String todo = tokens[1];
                    for (int i = 2; i < tokens.length; i++) {
                        todo = todo + " " + tokens[i];
                    }
                    Task t = new Todo(todo);
                    tasks.addTask(t);
                }
                break;
            case "deadline":
                String deadline = tokens[1], by = "";
                int by_token = 2;
                for (int i = 2; i < tokens.length && !tokens[i].equals("/by"); i++){
                    deadline = deadline + " " + tokens[i];
                    by_token = i + 1;
                }
                by = tokens[by_token + 1];
                for (int i = by_token + 2; i < tokens.length; i++){
                    by = by + " " + tokens[i];
                }

                if (by.contains("/")){
                    by = DateFormatter.formatDate(by);
                }

                Task d = new Deadline(deadline, by);
                tasks.addTask(d);
                break;
            case "event":
                String event = tokens[1], at = "";
                int at_token = 2;
                for (int i = 2; i < tokens.length && !tokens[i].equals("/at"); i++){
                    event = event + " " + tokens[i];
                    at_token = i + 1;
                }
                at = tokens[at_token + 1];
                for (int i = at_token + 2; i < tokens.length; i++){
                    at = at + " " + tokens[i];
                }

                if (at.contains("/")){
                    at = DateFormatter.formatDate(at);
                }

                Task e = new Event(event, at);
                tasks.addTask(e);
                break;
            case "delete":
                tasks.deleteTask( Integer.parseInt(tokens[1]) - 1 );
        		break;

            case "find":
                tasks.findTasks( s.replaceFirst("find ", ""));
                break;
            default:
                throw new DukeException("Error! Unrecognisable command inputted");
        }


    }

}
