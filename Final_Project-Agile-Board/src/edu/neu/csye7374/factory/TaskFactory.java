package edu.neu.csye7374.factory;
import edu.neu.csye7374.model.Account;
import edu.neu.csye7374.model.Task;
import edu.neu.csye7374.model.TaskStatus;

public class TaskFactory {
    public static TaskFactory instance = new TaskFactory();

    private TaskFactory() {
    }

    public Task getTask(String description, Account assignee) {
        return new Task("Review Code", assignee);
    }

    public Task getTask(String description, Account assignee, TaskStatus status) {
        return new Task("Review Code", assignee, status);
    }
}
