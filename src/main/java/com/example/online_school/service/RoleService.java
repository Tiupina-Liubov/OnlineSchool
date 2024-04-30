package com.example.online_school.service;

import com.example.online_school.dto.RoleAfterCreateDto;
import com.example.online_school.dto.RoleCreateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.exception.ObjectAlreadyExistsException;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    Role getRoleById(UUID id);
    List<Role> getAllRoles();

    RoleAfterCreateDto createRole(RoleCreateDto roleCreateDto) throws ObjectAlreadyExistsException;
}
