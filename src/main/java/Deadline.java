/**
 * This class defines the Deadline task as an object that the user can create when inputting the description
 * and the deadline timing.
 */

public class Deadline extends Task {

    protected String by;

    /**
     * This constructor creates the Deadline task with the description and deadline timing provided by the user.
     * @param description This is the information that the user inputs into Duke when creating the Deadline task.
     * @param by This is the deadline timing that the user inputs for the Deadline task.
     */

    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
