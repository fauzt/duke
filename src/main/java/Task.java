import java.io.Serializable;

/**
 * This class defines the task as an object along with the necessary fields. All operations that manipulate
 * the task itself such as reading its description, marking it as done, etc. is done here.
 */

public class Task implements Serializable {
    protected String description;
    protected boolean isDone;

    /**
     * This constructor creates the task when the user inputs the description information for the task.
     * @param description This is the information that the user inputs to label the task.
     */

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    /**
     * This method checks the status of task whether it is done or not and returns that information to the user.
     * @return The method returns a character corresponding to the 'done' status of the task.
     */

    public String getStatus(){
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * This method displays a standardised message of the task and all of its necessary information to the user.
     * @return The method returns the task's status and its description in a readable format to be displayed
     *         to the user.
     */

    public String toString(){
        return "[" + this.getStatus() + "] " + this.description;
    }

    /**
     * This method marks the status of the task as done.
     */

    public void markAsDone(){
        this.isDone = true;
    }

}
