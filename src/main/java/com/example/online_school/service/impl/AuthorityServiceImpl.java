package com.example.online_school.service.impl;

import com.example.online_school.entity.Authority;
import com.example.online_school.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl  implements AuthorityService {
    @Override
    public Authority getAuthorityById(UUID id) {
        return null;
    }
}
