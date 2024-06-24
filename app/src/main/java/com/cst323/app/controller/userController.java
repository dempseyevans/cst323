package com.cst323.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cst323.app.entity.user;
import com.cst323.app.service.userService;

@RequestMapping("/users")
public class userController {

    @Autowired
    private userService userService;

    @GetMapping
    public List<user> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping
    public user createUser(@RequestBody user user)
    {
        return userService.saveUser(user);
    }

    @PutMapping
    public user updateUser(@RequestBody user user)
    {
        return userService.saveUser(user);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }
}
