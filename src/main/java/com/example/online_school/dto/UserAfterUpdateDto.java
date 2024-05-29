package com.example.online_school.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Data transfer object (DTO) representing the response after updating a user's information.
 *
 * Объект передачи данных (DTO), представляющий ответ после обновления информации о пользователе.
 */
@Data
public class UserAfterUpdateDto {

    /**
     * The ID of the updated user.
     *
     * Идентификатор обновленного пользователя.
     */
    private UUID id;

    /**
     * The status message indicating that the user's data was updated successfully.
     *
     * Сообщение о статусе, указывающее, что данные пользователя были успешно обновлены.
     */
    private String status = "User data update";
}
