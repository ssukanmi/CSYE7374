package edu.neu.csye7374.builder;

import edu.neu.csye7374.model.Account;
import edu.neu.csye7374.model.Task;

import java.util.List;

public class AgileBoardBuilder {
    public List<Account> users = null;
    public List<Task> initialTasks = null;

    public AgileBoardBuilder users(List<Account> users) {
        this.users = users;
        return this;
    }

    public AgileBoardBuilder initialTasks(List<Task> tasks) {
        this.initialTasks = tasks;
        return this;
    }
}
