/**
 * This class defines the Event task as an object that the user can create when inputting the description
 * and the event timing.
 */

public class Event extends Task {

    protected String at;

    /**
     * This constructor creates the Deadline task with the description and event timing provided by the user.
     * @param description This is the information that the user inputs into Duke when creating the Event task.
     * @param at This is the event timing that the user inputs for the Event task.
     */

    public Event(String description, String at){
        super(description);
        this.at = at;
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + "(at: " + at + ")";
    }
}
