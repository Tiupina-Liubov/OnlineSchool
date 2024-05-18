package com.example.online_school.constraint;

import com.example.online_school.annotation.UserCreateValidityChecker;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserCreateValidityCheckerConstraint implements ConstraintValidator<UserCreateValidityChecker, UserCreateDto> {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}$";
    private static final String PHONE_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private static final String NAME_PATTERN = "^[a-zA-Z\\s]*$";
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";

    private final UserRepository userRepository;

    public UserCreateValidityCheckerConstraint(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UserCreateValidityChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserCreateDto value, ConstraintValidatorContext context) throws NullPointerException {
        boolean isValid = true;
        List<String> emails = new ArrayList<>(userRepository.findAllEmail());
        List<String> usernames = new ArrayList<>(userRepository.findAllUsername());

        if (value != null) {

            if (!Pattern.matches(EMAIL_PATTERN, value.getEmail())) {
                context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_EMAIL).addConstraintViolation();
                isValid = false;
            }
            if(emails.contains(value.getEmail())){
                context.buildConstraintViolationWithTemplate(ErrorMessage.USER_WITH_SUCH_EMAIL_EXISTS).addConstraintViolation();
                isValid=false;
            }

            if (!Pattern.matches(PASSWORD_PATTERN, value.getPassword())) {
                context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_PASSWORD).addConstraintViolation();
                isValid = false;
            }

            if (!Pattern.matches(PHONE_PATTERN, value.getPhoneNumber())) {
                context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_PHONE_NUMBER).addConstraintViolation();
                isValid = false;
            }

            if (!Pattern.matches(NAME_PATTERN, value.getFirstName())) {
                context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_FIRST_NAME).addConstraintViolation();
                isValid = false;
            }

            if (!Pattern.matches(NAME_PATTERN, value.getLastName())) {
                context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_LASTNAME).addConstraintViolation();
                isValid = false;
            }
            if (!Pattern.matches(USERNAME_PATTERN, value.getUsername())) {
                context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_USERNAME).addConstraintViolation();
                isValid = false;
            }
            if (usernames.contains(value.getUsername())) {
                context.buildConstraintViolationWithTemplate(ErrorMessage.USERNAME_ALREADY_EXISTS).addConstraintViolation();
                isValid = false;
            }

        } else {
            throw new NullPointerException(ErrorMessage.NULL_POINTER);
        }
        return isValid;
    }
}
