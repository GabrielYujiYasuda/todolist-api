package com.gabrielyasuda.todolist.controllers;

import com.gabrielyasuda.todolist.dtos.TaskDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")

public class TaskController {


    //CREATING A NEW TASK
        //can create a task with same name and description
    //DELETING TASK
        //check if the task exists
    //GET ALL TASK
        //if there's no task, return a message
    //GET ONE TASK
        //return the task by the name or similar name
        //if there's no task, return a message
    //UPDATE AN TASK
        //check if the task exists, if not return a message
        //only update NOT COMPLETED tasks
}
