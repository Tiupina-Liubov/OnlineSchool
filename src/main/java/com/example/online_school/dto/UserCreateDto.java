package com.example.online_school.dto;

import com.example.online_school.exception.errorMessage.ErrorMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

import java.time.LocalDate;

/**
 * Data transfer object (DTO) representing the information required to create a new user.
 *
 * Объект передачи данных (DTO), представляющий информацию, необходимую для создания нового пользователя.
 */
@Value
public class UserCreateDto {

    /**
     * The first name of the user.
     *
     * Имя пользователя.
     */
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = ErrorMessage.INVALID_FIRST_NAME)
    String firstName;

    /**
     * The last name of the user.
     *
     * Фамилия пользователя.
     */
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = ErrorMessage.INVALID_LASTNAME)
    String lastName;

    /**
     * The birthday of the user.
     *
     * День рождения пользователя.
     */
    LocalDate birthday;

    /**
     * The email address of the user.
     *
     * Адрес электронной почты пользователя.
     */
    @Email(message = ErrorMessage.INVALID_EMAIL)
    String email;

    /**
     * The username used for logging into the system.
     *
     * Имя пользователя, используемое для входа в систему.
     * - Must contain only alphanumeric characters.
     * - Может содержать только буквенно-цифровые символы.
     */
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = ErrorMessage.INVALID_USERNAME)
    String username;

    /**
     * The password used for logging into the system.
     *
     * Пароль, используемый для входа в систему.
     * - Must be at least 8 characters long.
     * - Must contain at least one uppercase letter, one digit, and one special character from '@#$%^&+=!'.
     * - Должен содержать не менее 8 символов.
     * - Должен содержать как минимум одну заглавную букву, одну цифру и один специальный символ из '@#$%^&+=!'.
     */
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$", message = ErrorMessage.INVALID_PASSWORD)
    String password;

    /**
     * The phone number of the user.
     *
     * Номер телефона пользователя.
     * - Must start with a '+' sign followed by digits.
     * - Can have spaces between digits.
     * - Must contain between 6 and 14 digits after the '+' sign.
     * - Должен начинаться с символа '+' и следовать за ним цифры.
     * - Может содержать пробелы между цифрами.
     * - После символа '+' должно быть от 6 до 14 цифр.
     */
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = ErrorMessage.INVALID_PHONE_NUMBER)
    String phoneNumber;

}
