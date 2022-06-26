package com.karthick.budget_manager.controller;

import com.karthick.budget_manager.datarepo.UserRepository;
import com.karthick.budget_manager.dto.UserDto;
import com.karthick.budget_manager.model.User;
import com.karthick.budget_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/signin/{email}")
    public UserDto getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }
}

