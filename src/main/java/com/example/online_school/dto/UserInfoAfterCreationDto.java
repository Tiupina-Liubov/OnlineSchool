package com.example.online_school.dto;

import lombok.Data;

@Data
public class UserInfoAfterCreationDto {

    private String userId;

    public  String status= "USER CREATED";
}
