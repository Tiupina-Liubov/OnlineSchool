package com.example.online_school.dto;

import lombok.Data;

/**
 * Data transfer object (DTO) representing the response after creating a user.
 */
@Data
public class UserAfterCreationDto {

    /**
     * The ID of the created user.
     */
    private String id;

    /**
     * The status message indicating that the user was created successfully.
     */
    public String status = "USER CREATED";
}
