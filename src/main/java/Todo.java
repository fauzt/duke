/**
 * This class defines the 'Todo' task as an object based on the Task class.
 */

public class Todo extends Task {

    /**
     * This constructor creates the Todo object with the description inputted by the user.
     * @param description This is the information that the user inputs into Duke when creating the Todo task.
     */

    public Todo(String description){
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
