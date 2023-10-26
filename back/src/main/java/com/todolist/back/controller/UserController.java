package com.todolist.back.controller;

import com.todolist.back.Repository.UserRepository;
import com.todolist.back.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}

