package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Data transfer object (DTO) representing the response after updating a user's information.
 */
@Data
public class UserAfterUpdateDto {

    /**
     * The ID of the updated user.
     */
    private UUID id;

    /**
     * The status message indicating that the user's data was updated successfully.
     */
    private String status = "User data update";
}
