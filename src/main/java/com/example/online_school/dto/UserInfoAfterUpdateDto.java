package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Data transfer object (DTO) representing the response after updating user information.
 *
 * Объект передачи данных (DTO), представляющий ответ после обновления информации о пользователе.
 */
@Data
public class UserInfoAfterUpdateDto {

    /**
     * The ID of the updated user information.
     *
     * Идентификатор обновленной информации о пользователе.
     */
    private UUID id;

    /**
     * The status message indicating that the user information was successfully updated.
     *
     * Сообщение о статусе, указывающее, что информация о пользователе была успешно обновлена.
     */
    private String status = "User info data update";
}


