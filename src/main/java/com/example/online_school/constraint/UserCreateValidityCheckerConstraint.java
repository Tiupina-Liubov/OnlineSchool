package com.example.online_school.constraint;

import com.example.online_school.annotation.UserCreateValidityChecker;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class UserCreateValidityCheckerConstraint implements ConstraintValidator<UserCreateValidityChecker, UserCreateDto> {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$";
    private static final String PHONE_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private static final String NAME_PATTERN = "^[a-zA-Z\\s]*$";
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";

    @Override
    public void initialize(UserCreateValidityChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserCreateDto value, ConstraintValidatorContext context) throws NullPointerException {// todo ХОЧУ написать через КЕЙС!!!!!!
        boolean isValid = true;

        if (value != null) {

            if (!Pattern.matches(EMAIL_PATTERN, value.getEmail())){
                context.buildConstraintViolationWithTemplate("Invalid email").addConstraintViolation();
                isValid = false;
            }

            if (!Pattern.matches(PASSWORD_PATTERN, value.getPassword())){
                context.buildConstraintViolationWithTemplate("Invalid password").addConstraintViolation();
                isValid = false;
            }

            if (!Pattern.matches(PHONE_PATTERN, value.getPhoneNumber())){
                context.buildConstraintViolationWithTemplate("Invalid phone number").addConstraintViolation();
                isValid = false;
            }

            if (!Pattern.matches(NAME_PATTERN, value.getFirstName())){
                context.buildConstraintViolationWithTemplate("Invalid first name").addConstraintViolation();
                isValid = false;
            }

            if (!Pattern.matches(NAME_PATTERN, value.getLastName())){
                context.buildConstraintViolationWithTemplate("Invalid last name").addConstraintViolation();
                isValid = false;
            }
            if (!Pattern.matches(USERNAME_PATTERN, value.getUsername())){// todo добавить проверку на сушествуюшей username
                context.buildConstraintViolationWithTemplate("Invalid username").addConstraintViolation();
                isValid = false;
            }

        }else {
            throw new NullPointerException(ErrorMessage.NULL_POINTER);
        }
        return isValid;
    }
}
