package com.example.online_school.service.impl;

import com.example.online_school.entity.User;
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
      return  userRepository.getUserById(id);

    }
}
