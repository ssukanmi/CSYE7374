package edu.neu.csye7374.model;
import java.util.Arrays;
import java.util.List;

public enum TaskStatus {
    TODO("TODO"),
    DOING("DOING"),
    DONE("DONE");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static List<TaskStatus> allCases() {
        return List.of(values());
    }

    public static TaskStatus getStatusFromString(String status) {
        return Arrays.stream(values())
                .filter(taskStatus -> taskStatus.getStatus().equals(status))
                .findFirst()
                .orElse(null);
    }
}
