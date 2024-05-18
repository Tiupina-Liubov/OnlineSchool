package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserInfoAfterUpdateDto {
    UUID id;

    String status ="User info data update";
}

