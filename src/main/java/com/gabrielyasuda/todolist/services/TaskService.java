package com.gabrielyasuda.todolist.services;

import com.gabrielyasuda.todolist.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

}
