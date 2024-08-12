package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.MongoUser;
import com.service.MongoUserService;

@RestController
@RequestMapping("/api/users")
public class MongoUserController {
    @Autowired
    private MongoUserService userService;

    @GetMapping
    public List<MongoUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public MongoUser getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public MongoUser createUser(@RequestBody MongoUser user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public MongoUser updateUser(@PathVariable String id, @RequestBody MongoUser user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
