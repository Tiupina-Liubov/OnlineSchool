package com.example.online_school.dto;

import com.example.online_school.exception.errorMessage.ErrorMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

/**
 * Data transfer object (DTO) representing the information required to create a new user.
 */

@Getter
@Setter
@AllArgsConstructor
public class UserCreateDto {

    /**
     * The first name of the user.
     */
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = ErrorMessage.INVALID_FIRST_NAME)
    String firstName;

    /**
     * The last name of the user.
     */
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = ErrorMessage.INVALID_LASTNAME)
    String lastName;

    /**
     * The birthday of the user.
     */
    LocalDate birthday;

    /**
     * The email address of the user.
     */
    @Email(message = ErrorMessage.INVALID_EMAIL)
    String email;

    /**
     * The username used for logging into the system.
     * - Must contain only alphanumeric characters.
     */
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = ErrorMessage.INVALID_USERNAME)
    String username;

    /**
     * The password used for logging into the system.
     * <p>
     * - Must be at least 8 characters long.
     * - Must contain at least one uppercase letter, one digit, and one special character from '@#$%^&+=!'.
     */
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$", message = ErrorMessage.INVALID_PASSWORD)
    String password;

    /**
     * The phone number of the user.
     * - Must start with a '+' sign followed by digits.
     * - Can have spaces between digits.
     * - Must contain between 6 and 14 digits after the '+' sign.
     */
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = ErrorMessage.INVALID_PHONE_NUMBER)
    String phoneNumber;


}
