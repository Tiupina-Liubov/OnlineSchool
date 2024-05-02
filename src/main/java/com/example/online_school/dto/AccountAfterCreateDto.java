package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AccountAfterCreateDto {

    private UUID accountId;

    private UUID userId;

    private UUID userInfoId;

    private String status = "ACCOUNT CREATED";

}
