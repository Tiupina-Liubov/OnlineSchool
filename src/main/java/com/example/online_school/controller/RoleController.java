package com.example.online_school.controller;

import com.example.online_school.annotation.DeleteRole;
import com.example.online_school.annotation.GetRole;
import com.example.online_school.annotation.GetRoles;
import com.example.online_school.annotation.UuidFormatChecker;
import com.example.online_school.dto.RoleAfterCreateDto;
import com.example.online_school.dto.RoleCreateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetRole(path = "/get/{id}")
    public Role getRoleById(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
        return roleService.getRoleById(UUID.fromString(id));
    }

    @GetRoles(path = "/allRoles/")
    public List<Role> getRoles() throws ObjectAlreadyExistsException {
        return roleService.getAllRoles();
    }

    @DeleteRole(path = "/delete/{id}")
    public String deleteRoleByID(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
        return roleService.deleteRoleById(UUID.fromString(id));
    }

    @PostMapping("/create")
    public RoleAfterCreateDto createRole(@RequestBody RoleCreateDto roleCreateDto) throws ObjectAlreadyExistsException {
        return roleService.createRole(roleCreateDto);
    }// todo надо розобратса с етим контролиром думаю проблема в авторити

    @GetMapping("/users/roleName")
    public Set<User> getRolesByUserName(@RequestParam("roleName") String roleName) throws ObjectNotFoundException {
        return roleService.getUsersByRole(roleName);
    }
}
