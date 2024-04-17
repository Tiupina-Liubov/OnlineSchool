package com.example.online_school.service;

import com.example.online_school.entity.User;
import com.example.online_school.exception.IdNotFoundException;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

    String deleteUserById(UUID id);


    User updateUserNameById(UUID id, String updateFirstName) throws IdNotFoundException;
}
