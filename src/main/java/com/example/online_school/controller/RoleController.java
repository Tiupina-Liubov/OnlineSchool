package com.example.online_school.controller;

import com.example.online_school.entity.Role;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/get/{id}")
    public Role getRoleById(@PathVariable("id") UUID id){
        return roleService.getRoleById(id);
    }
}
