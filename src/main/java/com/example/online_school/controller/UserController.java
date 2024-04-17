package com.example.online_school.controller;

import com.example.online_school.entity.User;
import com.example.online_school.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") UUID id) {

        return userService.getUserById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUserByID(@PathVariable("id") UUID id) {
        return userService.deleteUserById(id);
    }

    @PutMapping ("update/{id}/updateFirstName")
    public User updateUserNameById(@PathVariable("id") UUID id, @RequestParam String updateFirstName) {
        return userService.updateUserNameById(id, updateFirstName);
    }



}
