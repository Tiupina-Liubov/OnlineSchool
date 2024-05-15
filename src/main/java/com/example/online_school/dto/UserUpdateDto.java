package com.example.online_school.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class UserUpdateDto {

    String firstName;

    String lastName;

    LocalDate birthday;

    String email;

    String username;

    String password;

    String phoneNumber;

}
