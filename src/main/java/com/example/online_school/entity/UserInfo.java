package com.example.online_school.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class UserInfo {
    private UUID id;

    private String username;

    private String password;

    private Set<Role> roles;

    private User user;
    private BigDecimal salary;

    private String paymentTribute;

    private String email;

    private String phoneNumber;

    private ZonedDateTime createAt;

    private ZonedDateTime updateAt;
}


