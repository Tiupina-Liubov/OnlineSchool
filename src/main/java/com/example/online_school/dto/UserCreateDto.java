package com.example.online_school.dto;

import lombok.Value;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class UserCreateDto {

    String firstName;

    String lastName;

    LocalDate birthday;

}
