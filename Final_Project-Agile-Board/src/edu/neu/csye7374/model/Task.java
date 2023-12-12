package edu.neu.csye7374.model;
import java.util.UUID;

public class Task {
    private String description;
    private TaskStatus status;
    private int id;
    private Account assignedMember;

    public Task(String description, Account assignedMember) {
        this.description = description;
        this.status = TaskStatus.TODO;
        this.id = Math.abs(UUID.randomUUID().hashCode());
        this.assignedMember = assignedMember;
    }
    public Task(String description, Account assignedMember, TaskStatus status) {
        this.description = description;
        this.status = status;
        this.id = Math.abs(UUID.randomUUID().hashCode());
        this.assignedMember = assignedMember;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public Account getAssignedMember() {
        return assignedMember;
    }

    public String getConsoleDescription() {
        return "> Description: " + description + "\n" +
                "> Assigned To: " + assignedMember.getDisplayName() + "\n" +
                "> Status: " + status.toString() + "\n" +
                "> ID: " + id;
    }

    public void update(String description, Account assignedMember, TaskStatus status) {
        if (description != null) {
            this.description = description;
        }
        if (assignedMember != null) {
            this.assignedMember = assignedMember;
        }
        if (status != null) {
            this.status = status;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task task = (Task) obj;
        return id == task.id;
    }
}