package com.example.online_school.dto;


import com.example.online_school.entity.Authority;
import com.example.online_school.entity.enums.RoleName;
import lombok.Value;

import java.util.Set;

@Value
public class RoleCreateDto {

    RoleName roleName;

    Set<Authority> authorities;
}
