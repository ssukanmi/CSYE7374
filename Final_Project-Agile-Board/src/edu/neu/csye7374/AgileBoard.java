package edu.neu.csye7374;
import edu.neu.csye7374.builder.AgileBoardBuilder;
import edu.neu.csye7374.controller.Controller;
import edu.neu.csye7374.helper.*;
import edu.neu.csye7374.facade.ConsoleIO;
import edu.neu.csye7374.model.*;

import java.util.ArrayList;
import java.util.List;

class AgileBoard {
    private Controller controller;

    public AgileBoard(AgileBoardBuilder builder) {
        this.controller = new Controller(builder.initialTasks, builder.users);
    }

    public void launch() {
        ConsoleIO console = ConsoleIO.getInstance();
        console.writeMessage("Welcome to Agile Team for CSYE 7374", ConsoleIO.OutputType.STANDARD);

        while (true) {
            Role currentAccountRole = null;
            if (controller.getCurrentAccount() != null) {
                currentAccountRole = controller.getCurrentAccount().getRole();
            }
            List<InputOption> launchOptions = InputOption.getLaunchOptions(currentAccountRole);
            console.writeMessage("Choose option from the Menu:\n" + ArrayUtils.printableMenu(launchOptions), ConsoleIO.OutputType.STANDARD);
            InputOption selectedOption = console.acceptInput(null, launchOptions);

            switch (selectedOption) {
                case LOG_IN_TO_ACCOUNT:
                    if (login()) {
                        continue;
                    } else {
                        List<InputOption> loginOptions = new ArrayList<>();
                        loginOptions.add(InputOption.RETRY);
                        loginOptions.add(InputOption.TERMINATE);
                        InputOption input = console.acceptInput("Choose option from the Menu:\n" + ArrayUtils.printableMenu(loginOptions), loginOptions);

                        if (input == InputOption.RETRY) {
                            continue;
                        } else {
                            return;
                        }
                    }
                case CREATE_TASK:
                    while (createTask()) {}
                    break;
                case VIEW_TASKS:
                case VIEW_MY_TASKS:
                    listTasks(selectedOption == InputOption.VIEW_TASKS ? null : controller.getCurrentAccount());

                    if (controller.tasks().isEmpty()) {
                        continue;
                    }

                    List<InputOption> taskOptions = InputOption.getTaskMenuOptions(controller.getCurrentAccount().getRole());
                    console.writeMessage("Choose option from the Menu:\n" + ArrayUtils.printableMenu(taskOptions), ConsoleIO.OutputType.STANDARD);
                    InputOption selectedTaskOption = console.acceptInput(null, taskOptions);

                    switch (selectedTaskOption) {
                        case DELETE_TASK:
                            while (deleteTask()) {}
                            break;
                        case UPDATE_TASK:
                            while (updateTask()) {}
                            break;
                        default:
                            break;
                    }
                    break;
                case LOGOUT:
                    controller.logOut();
                    continue;
                default:
                    return;
            }
        }
    }

    private boolean login() {
        ConsoleIO console = ConsoleIO.getInstance();
        String username = console.acceptInput("Please enter username:", String::valueOf, null);
        String password = console.acceptInput("Please enter password:", String::valueOf, null);

        try {
            controller.login(username, password);
            return true;
        } catch (Exception e) {
            handleControllerError(e);
        }

        return false;
    }

    private boolean createTask() {
        ConsoleIO console = ConsoleIO.getInstance();
        String taskDescription = console.acceptInput("Please enter task description:", String::valueOf, null);

        while (true) {
            StringBuilder userListDescription = new StringBuilder("Please input username of the assignee from the list below:\n");

            for (Account user : controller.accounts()) {
                userListDescription.append("> Name: ").append(user.getDisplayName()).append(", Username: ").append(user.getUsername()).append("\n");
            }

            String username = console.acceptInput(userListDescription.toString(), String::valueOf, input -> {
                for (Account user : controller.accounts()) {
                    if (user.getUsername().equals(input)) {
                        return true;
                    }
                }
                return false;
            });

            Account assignee = null;

            for (Account user : controller.accounts()) {
                if (user.getUsername().equals(username)) {
                    assignee = user;
                    break;
                }
            }

            List<InputOption> confirmTaskOptions = new ArrayList<>();
            confirmTaskOptions.add(InputOption.YES);
            confirmTaskOptions.add(InputOption.PREVIOUS_MENU);
            InputOption createTaskConfirm = console.acceptInput("Please confirm if you would like to create this task:\n" + ArrayUtils.printableMenu(confirmTaskOptions), confirmTaskOptions);

            if (createTaskConfirm == InputOption.YES) {
                try {
                    controller.create(taskDescription, assignee);
                    console.writeMessage("Task created successfully", ConsoleIO.OutputType.STANDARD);
                    break;
                } catch (Exception e) {
                    handleControllerError(e);
                    List<InputOption> optionsUponError = new ArrayList<>();
                    optionsUponError.add(InputOption.ASSIGN_TO_ANOTHER_MEMBER);
                    optionsUponError.add(InputOption.PREVIOUS_MENU);
                    InputOption input = console.acceptInput("Choose option from the Menu:\n" + ArrayUtils.printableMenu(optionsUponError), optionsUponError);

                    if (input == InputOption.ASSIGN_TO_ANOTHER_MEMBER) {
                        continue;
                    }

                    return false;
                }
            }
        }

        List<InputOption> confirmationOptions = new ArrayList<>();
        confirmationOptions.add(InputOption.CREATE_ANOTHER_TASK);
        confirmationOptions.add(InputOption.PREVIOUS_MENU);
        InputOption input = console.acceptInput("Choose option from the Menu:\n" + ArrayUtils.printableMenu(confirmationOptions), confirmationOptions);
        return input == InputOption.CREATE_ANOTHER_TASK;
    }

    private void listTasks(Account user) {
        List<Task> tasks;

        if (user != null) {
            tasks = new ArrayList<>();

            for (Task task : controller.tasks(user, null)) {
                if (task.getAssignedMember().equals(user)) {
                    tasks.add(task);
                }
            }
        } else {
            tasks = controller.tasks();
        }

        if (tasks.isEmpty()) {
            ConsoleIO.getInstance().writeMessage("There are currently no tasks.", ConsoleIO.OutputType.STANDARD);
        } else {
            for (Task task : tasks) {
                ConsoleIO.getInstance().writeMessage(task.getConsoleDescription() + "\n", ConsoleIO.OutputType.STANDARD);
            }
        }
    }

    private boolean deleteTask() {
        ConsoleIO console = ConsoleIO.getInstance();
        String input = console.acceptInput("Please enter task id:", String::valueOf, userInp -> {
            try {
                Integer.parseInt(userInp);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        });

        try {
            controller.deleteTask(Integer.parseInt(input));
            console.writeMessage("Task deleted successfully.", ConsoleIO.OutputType.STANDARD);
        } catch (Exception e) {
            handleControllerError(e);
        }

        List<InputOption> confirmationOptions = new ArrayList<>();
        confirmationOptions.add(InputOption.YES);
        confirmationOptions.add(InputOption.NO);
        InputOption confirmation = console.acceptInput("Would you like to delete another task?\n" + ArrayUtils.printableMenu(confirmationOptions), confirmationOptions);
        return confirmation == InputOption.YES;
    }

    private boolean updateTask() {
        ConsoleIO console = ConsoleIO.getInstance();
        String input = console.acceptInput("Please enter task id:", String::valueOf, userInp -> {
            try {
                Integer.parseInt(userInp);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        });

        try {
            List<InputOption> updateTaskOptions = InputOption.getTaskUpdateOptions(controller.getCurrentAccount().getRole());
            console.writeMessage("Choose option from the Menu:\n" + ArrayUtils.printableMenu(updateTaskOptions), ConsoleIO.OutputType.STANDARD);
            InputOption selectedOption = console.acceptInput(null, updateTaskOptions);

            switch (selectedOption) {
                case UPDATE_TASK_STATUS:
                    TaskStatus selectedTaskStatus = console.acceptInput("Choose option from the Menu:\n" + ArrayUtils.printableMenu(TaskStatus.allCases()), TaskStatus.allCases());
                    controller.updateTask(Integer.parseInt(input), selectedTaskStatus);
                    break;
                case UPDATE_TASK_ASSIGNEE:
                    StringBuilder userListDescription = new StringBuilder("Please input username or used-id of the assignee from the list below:\n");

                    for (Account user : controller.accounts()) {
                        userListDescription.append("> Name: ").append(user.getDisplayName()).append(", Username: ").append(user.getUsername()).append(", User ID: ").append(user.getId()).append("\n");
                    }

                    String usernameOrId = console.acceptInput(userListDescription.toString(), String::valueOf, inputStr -> {
                        for (Account user : controller.accounts()) {
                            if (user.getUsername().equals(inputStr) || user.getId() == Integer.parseInt(inputStr)) {
                                return true;
                            }
                        }

                        return false;
                    });

                    Account assignee = null;

                    for (Account user : controller.accounts()) {
                        if (user.getUsername().equals(usernameOrId) || user.getId() == Integer.parseInt(usernameOrId)) {
                            assignee = user;
                            break;
                        }
                    }

                    controller.updateTask(Integer.parseInt(input), assignee);
                    break;
                case UPDATE_TASK_DESCRIPTION:
                    String taskDescription = console.acceptInput("Please enter task description:", String::valueOf, null);
                    controller.updateTask(Integer.parseInt(input), taskDescription);
                    break;
                case PREVIOUS_MENU:
                case LOG_IN_TO_ACCOUNT:
                    return false;
                default:
                    throw new Exception("Unspecified Option Selected.");
            }
        } catch (Exception e) {
            handleControllerError(e);
        }

        List<InputOption> confirmationOptions = new ArrayList<>();
        confirmationOptions.add(InputOption.YES);
        confirmationOptions.add(InputOption.NO);
        InputOption confirmation = console.acceptInput("Would you like to update another task?\n" + ArrayUtils.printableMenu(confirmationOptions), confirmationOptions);
        return confirmation == InputOption.YES;
    }

    private void handleControllerError(Exception err) {
        ConsoleIO console = ConsoleIO.getInstance();

        if (err instanceof ConsoleError) {
            console.writeMessage(err.getMessage(), ConsoleIO.OutputType.STANDARD);
        } else {
            console.writeMessage("Unknown error occurred", ConsoleIO.OutputType.STANDARD);
        }
    }
}