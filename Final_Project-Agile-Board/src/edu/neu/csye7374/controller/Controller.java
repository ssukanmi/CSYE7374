package edu.neu.csye7374.controller;
import java.util.ArrayList;
import edu.neu.csye7374.model.*;
import java.util.List;

public class Controller {
    private List<Task> tasks;
    private List<Account> accounts;
    private Account currentAccount;

    public List<Task> tasks() {
        return tasks;
    }

    public List<Account> accounts() {
        return accounts;
    }

    public Controller(List<Task> initialTasks, List<Account> initialUsers) {
        this.tasks = initialTasks;
        this.accounts = initialUsers;
    }

    // Login User
    public void login(String username, String password) throws ConsoleError {
        Account account = accounts.stream()
                .filter(a -> a.getUsername().equals(username) && a.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        if (account != null) {
            currentAccount = account;
        } else {
            throw new ConsoleError("Failed to login. Invalid credentials.");
        }
    }

    public void logOut() {
        currentAccount = null;
    }

    // create task and assign to a member
    public void create(String description, Account assignedMember) throws ConsoleError {
        if (description.isEmpty()) {
            throw new ConsoleError("Task could not be created due to invalid description...");
        }
        // When a member has >= 2 DOING tasks, this member should not be assigned new tasks.
        if (tasks.stream().filter(t -> assignedMember.getUsername().equals(t.getAssignedMember().getUsername()) && t.getStatus() == TaskStatus.DOING).count() >= 2) {
            throw new ConsoleError("This team member can not be assigned new tasks as they already have 2 tasks with the DOING status.");
        }
        Task newTask = new Task(description, assignedMember);
        tasks.add(newTask);
    }

    // Update task

    // Updates Task Description
    public void updateTask(int input, String taskDescription) throws ConsoleError {
        this.updateTask(input, taskDescription);
    }

    // Assigns the task to another assignee
    public void updateTask(int input, Account assignToAnother) throws ConsoleError {
        this.updateTask(input, assignToAnother);
    }
    public void updateTask(int input, TaskStatus selectedTaskStatus) throws ConsoleError {
        this.updateTask(input, null, null, selectedTaskStatus);
    }
    public void updateTask(int taskId, String description, Account teamMember, TaskStatus status) throws ConsoleError {
        // if assignee have more than 2 task in doing, then don't assign the assignee
        // if in doing status, should not be assigned to new member
        // if in done status, should not be assigned to new member
        if (description != null && description.isEmpty())
            throw new ConsoleError("Task could not be updated due to invalid description...");
        // When a member has >= 2 DOING tasks, this member should not be assigned new tasks.
        if (teamMember != null && tasks.stream().filter(t -> t.getAssignedMember().equals(teamMember) && t.getStatus() == TaskStatus.DOING).count() >= 2)
            throw new ConsoleError("This team member can not be assigned this task as they already have 2 tasks with the DOING status.");
        int index = -1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                index = i;
                break;
            }
        }
        if (index == -1) throw new ConsoleError("No task associated with this ID found.");
        if ((tasks.get(index).getStatus() == TaskStatus.DOING) && (tasks.get(index).getAssignedMember().getUsername() != currentAccount.getUsername()))
            throw new ConsoleError("Error: This task is in DOING status hence, can't be updated..");
        if (tasks.get(index).getStatus() == TaskStatus.DONE)
            throw new ConsoleError("Error: You're trying to assign a task that is already DONE.");
        tasks.get(index).update(description, teamMember, status);
    }

    // GET all tasks assigned to a user/account
    public List<Task> tasks(Account assignee, TaskStatus status) {
        List<Task> allTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getAssignedMember().getUsername().equals(assignee.getUsername())) {
                allTasks.add(task);
            }
        }
        if (status != null) {
            List<Task> filteredTasks = new ArrayList<>();
            for (Task task : allTasks) {
                if (task.getStatus() == status) {
                    filteredTasks.add(task);
                }
            }
            return filteredTasks;
        } else {
            return allTasks;
        }
    }

    public Task getTask(int id) throws ConsoleError {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new ConsoleError("Task not found. Please verify task-id and retry.");
    }

    public void deleteTask(int id) throws ConsoleError {
        int index = -1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            if (tasks.get(index).getStatus() == TaskStatus.DOING) {
                throw new ConsoleError("Error: The task you're trying to delete is in DOING state.");
            } else {
                tasks.remove(index);
            }
        } else {
            throw new ConsoleError("Task not found. Please verify task-id and retry.");
        }
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

}


