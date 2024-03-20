package com.example.online_school.entity;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class UserInfo {
    UUID id;
    String username;

    String password;
    Set<Role> roles;

    User user;
    DecimalFormat salary;

    String paymentTribute;
    String email;
    String phoneNumber;
    ZonedDateTime createAt;
    ZonedDateTime updateAt;
}


