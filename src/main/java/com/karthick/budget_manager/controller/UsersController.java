package com.karthick.budget_manager.controller;

import com.karthick.budget_manager.datarepo.UserRepository;
import com.karthick.budget_manager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") int id) {
        return userRepo.findById(id);
    }

    @GetMapping("/user/signin/{email}")
    public Optional<User> getUserByEmail(@PathVariable("email") String email) {
        return userRepo.findByEmail(email);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }
}
