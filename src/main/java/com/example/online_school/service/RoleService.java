package com.example.online_school.service;

import com.example.online_school.entity.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoleService {
    Role getRoleById(UUID id);
    List<Role> getAllRoles();
}
