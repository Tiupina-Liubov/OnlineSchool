package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;
@Data
public class UserAfterUpdateDto {

    UUID id;

    String status ="User data update";
}
