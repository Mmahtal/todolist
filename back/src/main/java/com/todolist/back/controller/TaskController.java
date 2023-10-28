package com.todolist.back.controller;

import com.todolist.back.model.Task;
import com.todolist.back.Repository.TaskRepository;
import com.todolist.back.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.todolist.back.Repository.UserRepository;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/addTask")
    public String addNewTask(
            @RequestParam Integer userId,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Task.Status status,
            @RequestParam Date creationDate,
            @RequestParam Date deadlineDate
    ) {
        User user = userRepository.findById(userId).orElse(null);

        if(user == null) {
            return "User not found";
        }

        Task newTask = new Task();
        newTask.setUser(user);
        newTask.setTitle(title);
        newTask.setDescription(description);
        newTask.setStatus(status);
        newTask.setCreationDate(creationDate);
        newTask.setDeadlineDate(deadlineDate);

        taskRepository.save(newTask);

        return "Tâche ajoutée avec succès";
    }
}
