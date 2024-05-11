package com.example.online_school.annotation;

import com.example.online_school.constraint.UserCreateValidityCheckerConstraint;
import com.example.online_school.constraint.UuidFormatCheckerConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserCreateValidityCheckerConstraint.class)
public @interface UserCreateValidityChecker {

    String message() default "IT IS NOT VALIDITY FORMAT";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
