package com.example.online_school.constraint;

import com.example.online_school.annotation.UuidFormatChecker;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Constraint validator for UUID format checker annotation.
 */
public class UuidFormatCheckerConstraint implements ConstraintValidator<UuidFormatChecker, String> {

    private static final String UUID_PATTERN = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    /**
     * Initialize the validator.
     *
     * @param constraintAnnotation the annotation to be applied.
     */
    @Override
    public void initialize(UuidFormatChecker constraintAnnotation) {
    }

    /**
     * Check if the given UUID string is valid.
     *
     * @param uuid    the UUID string to be validated.
     * @param context the context in which the constraint is evaluated.
     * @return true if the UUID string is valid, false otherwise.
     */
    @Override
    public boolean isValid(String uuid, ConstraintValidatorContext context) {
        if (uuid != null) {
            return Optional.of(uuid)
                    .filter(i -> !i.isBlank())
                    .map(el -> Pattern.compile(UUID_PATTERN).matcher(el).matches())
                    .orElse(false);
        }
        return false;
    }
}
