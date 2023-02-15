package com.gabrielyasuda.todolist.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_TASK")
public class TaskModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String taskName;

    @Column
    private String taskDescription;

    @Column(nullable = false)
    private LocalDate taskDate;

    //Getters & Setters BEGINNING
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }
    //Getters & Setters ENDING
}
