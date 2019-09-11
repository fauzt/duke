/**
 * This Exception class is used to handle exceptional cases that can occur due to errors in the program
 * or illegal commands from the user.
 */

public class DukeException extends Exception{
    public DukeException(){
        super();
    }
    public DukeException(String message){
        super(message);
    }
    public DukeException(String message, Throwable err){
        super(message, err);
    }
}
