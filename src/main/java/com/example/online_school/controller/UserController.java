package com.example.online_school.controller;

import com.example.online_school.annotation.CreateUser;
import com.example.online_school.annotation.DeleteUser;
import com.example.online_school.annotation.GetUser;
import com.example.online_school.annotation.UuidFormatChecker;
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
    public User getUserById(@UuidFormatChecker @PathVariable("id") String id) {//todo Узнать в субботу у преподователя об этом
        return userService.getUserById(UUID.fromString(id));
    }

    @DeleteUser(path = "/delete/{id}")
    public String deleteUserByID(@PathVariable("id") UUID id) {// todo посмотреть что не так с ролями некоторые пользователи не удаляются
        return userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}/")
    public User updateUser(@PathVariable("id") UUID id, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(id, userUpdateDto);// todo надо долелать маперр
    }

    @CreateUser(path = "/create")
    public UserAfterCreationDto createUser(@RequestBody UserCreateDto userCreateDto) throws ObjectAlreadyExistsException {
        return userService.createUser(userCreateDto);
    }

}

