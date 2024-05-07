package com.example.online_school.dto;

import com.example.online_school.entity.enums.RoleName;
import lombok.Data;

import java.util.Locale;

@Data
public class UserAfterCreationDto {

    private String id;

    public String status = "USER CREATED";
}
