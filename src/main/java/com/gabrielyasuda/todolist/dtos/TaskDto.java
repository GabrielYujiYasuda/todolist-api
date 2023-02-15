package com.gabrielyasuda.todolist.dtos;

import jakarta.validation.constraints.NotBlank;

public class TaskDto {

    @NotBlank
    private String taskName;
    private String taskDescription;

    @NotBlank
    private boolean taskComplete;

    //Getters & Setters BEGINNING
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isTaskComplete() {
        return taskComplete;
    }

    public void setTaskComplete(boolean taskComplete) {
        this.taskComplete = taskComplete;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    //Getters & Setters END
}
