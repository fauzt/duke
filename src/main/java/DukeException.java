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
