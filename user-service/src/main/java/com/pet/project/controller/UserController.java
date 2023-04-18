package com.pet.project.controller;

import com.pet.project.entity.User;
import com.pet.project.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello k8s!";
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        log.info("User to save: " + user.toString());
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public User getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @PostMapping("/users/{id}/posts")
    public int countPostForUser(@PathVariable Long id) {
        return userService.countNewPost(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
