package com.example.online_school.dto;


import lombok.Data;

@Data
public class UserAfterCreationDto {

    private String id;

    public String status = "USER CREATED";
}
