package com.example.online_school.annotation;

import com.example.online_school.entity.User;
import com.example.online_school.handler.ResponseExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to specify the creation of a new user.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.POST)
@Operation(
        summary = "Create new user",
        description = "Create new user and return him",
        tags = {"USER"},
        requestBody = @RequestBody(
                description = "The user to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = User.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = """
                                                {
                                                  "firstName": "Mark",
                                                  "lastName": "Schulz",
                                                  "birthday": "1984-05-01",
                                                  "email": "markschulz@gmail.com",
                                                  "username": "User1",
                                                  "password": "Markschulz123!",
                                                  "phoneNumber": "+38096179945"
                                                }
                                                """
                                ),
                                @ExampleObject(name = "Request with existing email",
                                        value = """ 
                                                {
                                                  "firstName": "Mark",
                                                  "lastName": "Schulz",
                                                  "birthday": "1984-05-01",
                                                  "email": "Kolya3@example.com",
                                                  "username": "User2",
                                                  "password": "Markschulz123!",
                                                  "phoneNumber": "+38096179945"
                                                }
                                                """
                                ),
                                @ExampleObject(name = "Not validate data",
                                        value = """ 
                                                {
                                                  "firstName": "Mark",
                                                  "lastName": "Schulz",
                                                  "birthday": "1984-05-01",
                                                  "email": "Kolya!3example.com",
                                                  "username": "markschulz123.",
                                                  "password": "Markschulz123!",
                                                  "phoneNumber": "+38096179945"
                                                }
                                                """
                                )
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "User created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = User.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "409",
                        description = "User already exist",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ResponseExceptionHandler.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Not valid date",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ResponseExceptionHandler.class)
                        )
                )

        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface CreateUser {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
