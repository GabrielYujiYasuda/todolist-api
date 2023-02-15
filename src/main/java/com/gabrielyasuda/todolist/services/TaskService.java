package com.gabrielyasuda.todolist.services;

import com.gabrielyasuda.todolist.models.TaskModel;
import com.gabrielyasuda.todolist.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //SAVE METHOD
    @Transactional
    public TaskModel save(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    //DELETE METHOD
    @Transactional
    public void delete(TaskModel taskModel) {
        taskRepository.delete(taskModel);
    }

    //FINDING ALL TASKS
    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    //FINDING TASK BY ID
    public Optional<TaskModel> findById(UUID id) {
        return taskRepository.findById(id);
    }
}
