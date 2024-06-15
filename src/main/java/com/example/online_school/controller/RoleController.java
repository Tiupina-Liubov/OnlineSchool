package com.example.online_school.controller;

import com.example.online_school.annotation.GetRole;
import com.example.online_school.annotation.GetRoles;
import com.example.online_school.annotation.UuidFormatChecker;
import com.example.online_school.entity.Role;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Controller class responsible for handling role-related HTTP requests.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    /**
     * Retrieves role information by its ID.
     *
     * @param id The ID of the role to retrieve.
     * @return The role object.
     * @throws IdNotFoundException if the provided ID does not exist.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetRole(path = "{id}")
    public Role getRoleById(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
        return roleService.getRoleById(UUID.fromString(id));
    }

    /**
     * Retrieves all roles.
     *
     * @return The list of role objects.
     * @throws ObjectAlreadyExistsException if the operation fails due to duplicate entries.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetRoles(path = "/allRoles/")
    public List<Role> getRoles() throws ObjectAlreadyExistsException {
        return roleService.getAllRoles();
    }


}
