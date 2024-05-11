package com.example.online_school.dto;

import com.example.online_school.entity.UserInfo;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class UserUpdateDto {

    String firstName;

    String lastName;

    LocalDate birthday;

    UserInfo userInfo;

   // String username;

//    String password;
//
//    BigDecimal salary;
//
//    String paymentTribute;
//
//    String phoneNumber;
//
//    String email;


}
