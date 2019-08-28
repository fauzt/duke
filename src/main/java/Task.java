import java.io.Serializable;

public class Task implements Serializable {
    protected String description;
    protected boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public String getStatus(){
        return (isDone ? "\u2713" : "\u2718");
    }

    public String toString(){
        return "[" + this.getStatus() + "] " + this.description;
    }

    public void markAsDone(){
        this.isDone = true;
    }

}
