package com.cst323.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cst323.app.entity.user;
import com.cst323.app.service.userService;

@Controller
@RequestMapping("/users")
public class userController {

    @Autowired
    private final userService userService;

    
    public userController(userService userService)
    {
        this.userService = userService;
    }

     @GetMapping("")
    public String getAllUsers(Model model)
    {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model)
    {
        model.addAttribute("userForm", new user());
        return "addUser";
    }
    
   

    @PostMapping("/save")
    public String createUser(@ModelAttribute("userForm") user user)
    {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String showEditUserForm(@PathVariable("id") Long id, Model model) {
        user user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") user updatedUser) {
        user existingUser = userService.getUserById(id);
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        userService.updateUser(existingUser); // Update the user using  userService
        return "redirect:/users"; // Redirect to the list of users after successful update
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id); // Delete the user using your userService
        return "redirect:/users"; // Redirect to the list of users after deletion
    }
}
