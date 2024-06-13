package com.example.online_school.dto;

import com.example.online_school.exception.errorMessage.ErrorMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

/**
 * Data transfer object (DTO) representing the request for creating user information.
 */
@Value
public class UserInfoCreateDto {

    /**
     * The email of the user.
     */
    @Email(message = ErrorMessage.INVALID_EMAIL, regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    String email;

    /**
     * The username of the user.
     */
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = ErrorMessage.INVALID_USERNAME)
    String username;

    /**
     * The password of the user.
     * <p>
     * Password must be at least 8 characters long and contain at least one uppercase letter, one digit, and one special character from: @#$%^&+=!
     */
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$",
            message = ErrorMessage.INVALID_PASSWORD)
    String password;

    /**
     * The phone number of the user.
     * <p>
     * Phone number must start with a '+' sign followed by country code and digits. It can include spaces between digits and must be between 8 and 15 characters long.
     */
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = ErrorMessage.INVALID_PHONE_NUMBER)
    String phoneNumber;
}
