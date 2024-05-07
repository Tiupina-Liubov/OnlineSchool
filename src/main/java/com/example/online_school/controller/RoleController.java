package com.example.online_school.controller;

import com.example.online_school.dto.RoleAfterCreateDto;
import com.example.online_school.dto.RoleCreateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/get/{id}")
    public Role getRoleById(@PathVariable("id") UUID id) {
        return roleService.getRoleById(id);
    }

    @GetMapping("/allRoles/")
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoleByID(@PathVariable("id") UUID id) {
        return roleService.deleteRoleById(id);
    }

    @PostMapping("/create")
    public RoleAfterCreateDto createRole(@RequestBody RoleCreateDto roleCreateDto) throws ObjectAlreadyExistsException {
        return roleService.createRole(roleCreateDto);
    }
}
