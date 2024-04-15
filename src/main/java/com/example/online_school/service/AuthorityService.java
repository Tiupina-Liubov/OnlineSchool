package com.example.online_school.service;

import com.example.online_school.entity.Authority;

import java.util.UUID;

public interface AuthorityService {
    Authority getAuthorityById(UUID id);
}
