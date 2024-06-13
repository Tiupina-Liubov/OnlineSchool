package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Data transfer object (DTO) representing the response after creating user information.
 */
@Data
public class UserInfoAfterCreationDto {

    /**
     * The ID of the created user information.
     * PUBLIC
     */
    private UUID id;

    /**
     * The status message indicating that the user information was created successfully.
     */
    public String status = "USER INFO CREATED";
}

