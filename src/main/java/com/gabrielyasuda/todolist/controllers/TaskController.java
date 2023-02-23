package com.gabrielyasuda.todolist.controllers;

import com.gabrielyasuda.todolist.dtos.TaskDto;
import com.gabrielyasuda.todolist.models.TaskModel;
import com.gabrielyasuda.todolist.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    final TaskService taskService;

    //Constructor
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //Saving a new task. There is no validation
    //Can be created tasks with same information
    @PostMapping
    public ResponseEntity<Object> saveTask(@RequestBody @Valid TaskDto taskDto) {
        var taskModel = new TaskModel();

        BeanUtils.copyProperties(taskDto, taskModel);
        //Setting the data. User can't do that
        taskModel.setTaskDate(LocalDate.from(LocalDateTime.now(ZoneId.of("UTC"))));

        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskModel));
    }

    //Deleting a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") UUID id) {
        Optional<TaskModel> taskModelOptional = taskService.findById(id);

        if (!taskModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }

        taskService.delete(taskModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully!");
    }

    //Getting all tasks
    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTask() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    //Getting one task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable(value = "id") UUID id) {
        Optional<TaskModel> taskModelOptional = taskService.findById(id);

        //Validating if task exists
        if (!taskModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(taskModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid TaskDto taskDto) {

        Optional<TaskModel> taskModelOptional = taskService.findById(id);

        //Validating if task exists
        if (!taskModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not foud");
        }

        var taskModel = taskModelOptional.get();

        taskModel.setTaskName(taskDto.getTaskName());
        taskModel.setTaskDescription(taskDto.getTaskDescription());
        taskModel.setTaskComplete(taskDto.isTaskComplete());

        return ResponseEntity.status(HttpStatus.OK).body(taskService.save(taskModel));
    }
}
