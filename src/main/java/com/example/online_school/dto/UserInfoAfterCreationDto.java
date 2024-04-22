package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserInfoAfterCreationDto {

    private UUID id;

    public  String status= "USER INFO CREATED";
}
