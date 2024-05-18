package com.example.online_school.service;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID id);

    String deleteUserById(UUID id);


    UserAfterCreationDto createUser(UserCreateDto userCreateDto) throws ObjectAlreadyExistsException;

    UserAfterUpdateDto updateUser(UUID id, UserUpdateDto userUpdateDto);

}
