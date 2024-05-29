package com.example.online_school.annotation;

import com.example.online_school.constraint.UuidFormatCheckerConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to validate UUID format.
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UuidFormatCheckerConstraint.class)
public @interface UuidFormatChecker {

    /**
     * Message to be displayed when validation fails.
     */
    String message() default "IT IS NOT UUID FORMAT";

    /**
     * Groups to which this constraint belongs.
     */
    Class<?>[] groups() default {};

    /**
     * Payload used by validation runtime.
     */
    Class<? extends Payload>[] payload() default {};

}
