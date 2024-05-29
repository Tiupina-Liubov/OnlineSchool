package com.example.online_school.dto;

import lombok.Data;

/**
 * Data transfer object (DTO) representing the response after creating a user.
 *
 * Объект передачи данных (DTO), представляющий ответ после создания пользователя.
 */
@Data
public class UserAfterCreationDto {

    /**
     * The ID of the created user.
     *
     * Идентификатор созданного пользователя.
     */
    private String id;

    /**
     * The status message indicating that the user was created successfully.
     *
     * Сообщение о статусе, указывающее, что пользователь был успешно создан.
     */
    public String status = "USER CREATED";
}
