package com.example.online_school.dto;


import lombok.Value;

@Value
public class UserCreateDto {

    String firstName;

    String lastName;

    Integer age;

    String email;
}
