package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleAfterCreateDto {

    UUID id;

    String created = "ROLE CREATED";
}
