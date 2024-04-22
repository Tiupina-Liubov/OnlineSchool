package com.example.online_school.dto;

import lombok.Value;

import javax.xml.crypto.Data;
import java.util.UUID;

@Value
public class UserCreateDto {


    String firstName;

    String lastName;

    Data birthday;

    String email;

    String username;

    String password;

    String phoneNumber;

}