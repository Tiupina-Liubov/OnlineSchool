package com.example.online_school.dto;

import lombok.Value;


@Value
public class UserInfoCreateDto {

    String email;

    String username;

    String password;

    String phoneNumber;

}
