package com.example.online_school.dto;

import lombok.Value;

import java.time.LocalDate;
import java.util.Date;

@Value
public class UserCreateDto {

    String firstName;

    String lastName;

    LocalDate birthday;

    String email;

    String username;

    String password;

    String phoneNumber;

}
