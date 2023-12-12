package edu.neu.csye7374;

import edu.neu.csye7374.builder.AgileBoardBuilder;
import edu.neu.csye7374.factory.AccountFactory;
import edu.neu.csye7374.factory.TaskFactory;
import edu.neu.csye7374.model.Account;
import edu.neu.csye7374.model.Task;
import edu.neu.csye7374.model.Role;
import edu.neu.csye7374.model.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    private AgileBoard agileBoard;
    private List<Account> users;
    private List<Task> tasks;

    public Demo() {
        List<Account> initialUsers = generateInitialUsers();
        List<Task> initialTasks = generateInitialTasks(initialUsers);

        AgileBoardBuilder builder = new AgileBoardBuilder();
        builder.users(generateInitialUsers())
                .initialTasks(initialTasks);

        agileBoard = new AgileBoard(builder);

        agileBoard.launch();
    }

    public List<Account> generateInitialUsers() {
        List<Account> users = new ArrayList<>();
        users.add(AccountFactory.instance.getAccount(Role.TEAM_LEAD, 1, "john.mic", "michael.j@", "John Michael"));
        users.add(AccountFactory.instance.getAccount(Role.TEAM_MEMBER, 2, "luke.lel", "lelay.l@", "Luke Lelay"));
        users.add(AccountFactory.instance.getAccount(Role.TEAM_MEMBER, 3, "nick.whi", "white.n@", "Nick White"));
        return users;
    }

    public List<Task> generateInitialTasks(List<Account> initialUsers) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(TaskFactory.instance.getTask("Review Code", initialUsers.get(0)));
        tasks.add(TaskFactory.instance.getTask("Review Milestone Plan", initialUsers.get(0)));
        tasks.add(TaskFactory.instance.getTask("Complete login module", initialUsers.get(1)));
        tasks.add(TaskFactory.instance.getTask("Complete facebook SDK integration", initialUsers.get(1)));
        tasks.add(TaskFactory.instance.getTask("Initiate Launch Screen Flow", initialUsers.get(1), TaskStatus.DONE));
        tasks.add(TaskFactory.instance.getTask("Complete Signup module", initialUsers.get(2)));
        tasks.add(TaskFactory.instance.getTask("Complete Google SDK integration", initialUsers.get(2)));
        tasks.add(TaskFactory.instance.getTask("Create tutorials", initialUsers.get(2), TaskStatus.DOING));
        tasks.add(TaskFactory.instance.getTask("Complete Launch Screen Flow", initialUsers.get(2), TaskStatus.DOING));
        return tasks;
    }
}

