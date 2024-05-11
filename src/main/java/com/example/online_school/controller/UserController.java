package com.example.online_school.controller;

import com.example.online_school.annotation.*;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetUser(path = "/get/{id}")
    public User getUserById(@UuidFormatChecker @PathVariable("id") String id) {
        return userService.getUserById(UUID.fromString(id));
    }

    @DeleteUser(path = "/delete/{id}")
    public String deleteUserByID(@PathVariable("id") String id) {// todo посмотреть что не так с ролями некоторые пользователи не удаляются
        return userService.deleteUserById(UUID.fromString(id));
    }

    @PutMapping("/update/{id}/")
    public User updateUser(@PathVariable("id") String id, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(UUID.fromString(id), userUpdateDto);// todo надо долелать маперр
    }

    @CreateUser(path = "/create")
    public UserAfterCreationDto createUser(@UserCreateValidityChecker @RequestBody UserCreateDto userCreateDto) throws ObjectAlreadyExistsException {
        return userService.createUser(userCreateDto);
    }

}

