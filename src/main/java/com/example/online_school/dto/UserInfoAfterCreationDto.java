package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Data transfer object (DTO) representing the response after creating user information.
 *
 * Объект передачи данных (DTO), представляющий ответ после создания информации о пользователе.
 */
@Data
public class UserInfoAfterCreationDto {

    /**
     * The ID of the created user information.
     *
     * Идентификатор созданной информации о пользователе.
     */
    private UUID id;

    /**
     * The status message indicating that the user information was created successfully.
     *
     * Сообщение о статусе, указывающее, что информация о пользователе была успешно создана.
     */
    public String status = "USER INFO CREATED";
}

