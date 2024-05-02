package com.example.online_school.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Value
public class AccountCreateDto {

    String firstName;

    String lastName;

    Date birthday;

    String email;

    String username;

    String password;

    String phoneNumber;



}
