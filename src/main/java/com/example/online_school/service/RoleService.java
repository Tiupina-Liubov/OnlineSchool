package com.example.online_school.service;

import com.example.online_school.entity.Role;
import com.example.online_school.exception.ObjectAlreadyExistsException;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing Role entities.
 */
public interface RoleService {

    /**
     * Retrieves a Role entity by its ID.
     *
     * @param id The ID of the Role entity.
     * @return The Role entity.
     */
    Role getRoleById(UUID id);

    /**
     * Retrieves all Role entities.
     *
     * @return The list of Role entities.
     */
    List<Role> getAllRoles() throws ObjectAlreadyExistsException;


}
