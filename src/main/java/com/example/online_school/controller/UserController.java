package com.example.online_school.controller;

import com.example.online_school.annotation.GetUser;
import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetUser(path = "/get/{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUserByID(@PathVariable("id") UUID id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("update/{id}/")
    public User updateUser(@PathVariable("id") UUID id, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(id, userUpdateDto);// todo надо долелать маперр
    }

    @PostMapping("/create")
    public UserAfterCreationDto createUser(@RequestBody UserCreateDto userCreateDto) throws ObjectAlreadyExistsException {
        return userService.createUser(userCreateDto);
    }
}

