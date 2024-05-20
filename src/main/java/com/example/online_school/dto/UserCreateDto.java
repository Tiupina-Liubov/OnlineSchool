package com.example.online_school.dto;

import com.example.online_school.exception.errorMessage.ErrorMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserCreateDto {
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = ErrorMessage.INVALID_FIRST_NAME)
    String firstName;

    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = ErrorMessage.INVALID_LASTNAME)
    String lastName;

    LocalDate birthday;

//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = ErrorMessage.USER_WITH_SUCH_EMAIL_EXISTS)
    @Email
    String email;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = ErrorMessage.INVALID_USERNAME)
    String username;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$", message = ErrorMessage.INVALID_PASSWORD)
    String password;

    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = ErrorMessage.INVALID_PHONE_NUMBER)
    String phoneNumber;

}
