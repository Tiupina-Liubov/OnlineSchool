package com.example.online_school.service;

import com.example.online_school.entity.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
