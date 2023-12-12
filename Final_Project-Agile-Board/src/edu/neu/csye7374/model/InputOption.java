package edu.neu.csye7374.model;

import java.util.ArrayList;
import java.util.List;

public enum InputOption {
    CREATE_ACCOUNT("Create Account"),
    LOG_IN_TO_ACCOUNT("Log In to Account"),
    LOGOUT("Log Out"),
    CREATE_TASK("Create Task"),
    VIEW_TASKS("View Tasks"),
    VIEW_MY_TASKS("View My Tasks"),
    UPDATE_TASK("Update Task"),
    DELETE_TASK("Delete Task"),
    PREVIOUS_MENU("Go To Previous Menu"),
    YES("YES"),
    NO("NO"),
    RETRY("Retry"),
    TERMINATE("Terminate"),
    CREATE_ANOTHER_TASK("Create Another Task"),
    ASSIGN_TO_ANOTHER_MEMBER("Assign Task to Another Member"),
    UPDATE_TASK_DESCRIPTION("Update Task Description"),
    UPDATE_TASK_ASSIGNEE("Update Task Assignee"),
    UPDATE_TASK_STATUS("Update Task Status");

    private final String value;

    InputOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<InputOption> getLaunchOptions(Role role) {
        List<InputOption> options = new ArrayList<>();
        if (role == null) {
            options.add(LOG_IN_TO_ACCOUNT);
            options.add(TERMINATE);
            return options;
        }
        switch (role) {
            case TEAM_LEAD:
                options.add(CREATE_TASK);
                options.add(VIEW_TASKS);
                options.add(VIEW_MY_TASKS);
                options.add(LOGOUT);
                break;
            case TEAM_MEMBER:
                options.add(VIEW_MY_TASKS);
                options.add(LOGOUT);
                break;
        }
        return options;
    }

    public static List<InputOption> getTaskMenuOptions(Role role) {
        List<InputOption> options = new ArrayList<>();
        if (role == null) {
            options.add(LOG_IN_TO_ACCOUNT);
            return options;
        }
        switch (role) {
            case TEAM_LEAD:
                options.add(UPDATE_TASK);
                options.add(DELETE_TASK);
                options.add(PREVIOUS_MENU);
                break;
            case TEAM_MEMBER:
                options.add(UPDATE_TASK);
                options.add(PREVIOUS_MENU);
                break;
        }
        return options;
    }

    public static List<InputOption> getTaskUpdateOptions(Role role) {
        List<InputOption> options = new ArrayList<>();
        if (role == null) {
            options.add(LOG_IN_TO_ACCOUNT);
            return options;
        }
        switch (role) {
            case TEAM_LEAD:
                options.add(UPDATE_TASK_DESCRIPTION);
                options.add(UPDATE_TASK_ASSIGNEE);
                options.add(UPDATE_TASK_STATUS);
                options.add(PREVIOUS_MENU);
                break;
            case TEAM_MEMBER:
                options.add(UPDATE_TASK_STATUS);
                options.add(PREVIOUS_MENU);
                break;
        }
        return options;
    }
}

