package com.example.online_school.dto;

import com.example.online_school.entity.enums.RoleName;
import lombok.Data;

@Data
public class UserAfterCreationDto {

    private String id;

    private RoleName roleName;

    public String status = "USER CREATED";
}
