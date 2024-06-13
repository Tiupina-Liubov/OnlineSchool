package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Data transfer object (DTO) representing the response after updating user information.
 */
@Data
public class UserInfoAfterUpdateDto {

    /**
     * The ID of the updated user information.
     */
    private UUID id;

    /**
     * The status message indicating that the user information was successfully updated.
     */
    private String status = "User info data update";
}


