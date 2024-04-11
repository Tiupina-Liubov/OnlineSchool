package com.example.online_school.service.impl;

import com.example.online_school.entity.User;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID id) {
        User user = userRepository.getUserById(id);

        if (user != null) {
            return user;

        } else {
            throw new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }
    }

    @Override
    public String deleteUserById(UUID id) {
        User user = userRepository.getUserById(id);

        if (user != null) {
            userRepository.deleteById(id);
            return "*****DELETE****";

        } else {
            throw new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }
    }
}
