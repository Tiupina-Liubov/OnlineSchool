package com.example.online_school.dto;

import com.example.online_school.exception.errorMessage.ErrorMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

/**
 * Data transfer object (DTO) representing the request for updating user information.
 *
 * Объект передачи данных (DTO), представляющий запрос на обновление информации о пользователе.
 */
@Value
public class UserInfoUpdateDto {

    /**
     * The email of the user.
     *
     * Email пользователя.
     */
    @Email(message = ErrorMessage.INVALID_EMAIL)
    String email;

    /**
     * The username of the user.
     *
     * Имя пользователя.
     */
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = ErrorMessage.INVALID_USERNAME)
    String username;

    /**
     * The password of the user.
     *
     * Пароль пользователя.
     *
     * Password must be at least 8 characters long and contain at least one uppercase letter, one digit, and one special character from: @#$%^&+=!
     *
     * Пароль должен содержать не менее 8 символов и содержать как минимум одну заглавную букву, одну цифру и один специальный символ из: @#$%^&+=!
     */
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$",
            message = ErrorMessage.INVALID_PASSWORD)
    String password;

    /**
     * The phone number of the user.
     *
     * Номер телефона пользователя.
     *
     * Phone number must start with a '+' sign followed by country code and digits. It can include spaces between digits and must be between 8 and 15 characters long.
     *
     * Номер телефона должен начинаться с символа '+' и следовать за ним код страны и цифры. Он может включать пробелы между цифрами и должен быть длиной от 8 до 15 символов.
     */
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = ErrorMessage.INVALID_PHONE_NUMBER)
    String phoneNumber;

//    String roleName;
}
