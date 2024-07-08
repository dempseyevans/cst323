package com.cst323.app.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cst323.app.entity.user;
import com.cst323.app.service.userService;






@Controller
@RequestMapping({"", "/"})
public class userController {

    private final userService userService;

    
    public userController(userService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public String addUserForm(Model model) {
        List<user> users = userService.getAllUsers();
        model.addAttribute("user", new user());
        return "addUser";
    }
    

     @GetMapping("/users")
    public String getAllUsers(Model model)
    {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }    

   @GetMapping("/register")
   public String showRegisterForm(Model model) {
       model.addAttribute("user", new user());
       return "register";
   }

   @PostMapping("/register")
   public String registerUser(@ModelAttribute("user") user user) {
        userService.saveUser(user);
        return "redirect:/login";
   }
   

   @GetMapping("/addUser")
   public String showAddUserForm(Model model) {
        model.addAttribute("user", new user());
       return "addUser";
   }
   
   @PostMapping("/login")
   public String processLogin(@ModelAttribute("user") user user) {
        
       return "redirect:/users";
   }
   
   
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("userForm") user user)
    {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String showEditUserForm(@PathVariable("id") Long id, Model model) {
        user user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/users/{id}/edit")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") user updatedUser) {
        user existingUser = userService.getUserById(id);
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setPassword(updatedUser.getPassword());
        userService.updateUser(existingUser); // Update the user using  userService
        return "redirect:/users"; // Redirect to the list of users after successful update
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id); // Delete the user using your userService
        return "redirect:/users"; // Redirect to the list of users after deletion
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserWithId(@PathVariable Long id) {
    userService.deleteUserById(id);
    return "redirect:/users";
}
    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") user user) {
        userService.saveUser(user);
        return "redirect:/users"; // Redirect to user list page or wherever appropriate
    }


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new user());
        return "addUser"; // Return the login page view name
    }
}