package com.example.online_school.controller;

import com.example.online_school.entity.User;
import com.example.online_school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") UUID id) {

        return userService.getUserById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUserByID(@PathVariable("id") UUID id) {
        return userService.deleteUserById(id);
    }


    @PutMapping("update/{id}/{updateFirstName}")
    public User updateUserNameById(@PathVariable("id") UUID id, @PathVariable("updateFirstName") String updateFirstName) {
        return userService.updateUserNameById(id, updateFirstName);
    }

}

