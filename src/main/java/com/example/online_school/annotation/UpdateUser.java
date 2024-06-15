package com.example.online_school.annotation;

import com.example.online_school.entity.User;
import com.example.online_school.handler.ResponseExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
 * Annotation to define a method as a PUT endpoint to update user information by ID.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.PUT)
@Operation(
        summary = "Update user by id",
        description = "Update user and return him",
        tags = {"USER"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the user",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Example request with correct Id",
                                        value = "d234d99d-170e-42f7-b6ae-435ee56f49b5"
                                ),
                                @ExampleObject(
                                        name = "Example request with non-exist Id",
                                        value = "55035fe9-37e3-466f-ba4a-197f23fc5701"
                                ),
                                @ExampleObject(
                                        name = "Example request with invalid Id",
                                        value = "d/34d99d-170e-42f7-aa6ae-435ee56f49b5"
                                )
                        }
                )
        },
        requestBody = @RequestBody(
                description = "The user to be updated",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = User.class),
                        examples = {
                                @ExampleObject(
                                        name = "Good request",
                                        value = """
                                                {
                                                  "firstName": "Mark",
                                                  "lastName": "",
                                                  "birthday": "",
                                                  "email": "",
                                                  "username": "",
                                                  "password": "",
                                                  "phoneNumber": ""
                                                }
                                                """
                                ),
                                @ExampleObject(
                                        name = "Request with existing email",
                                        value = """
                                                {
                                                  "firstName": "Mark",
                                                  "lastName": "",
                                                  "birthday": "",
                                                  "email": "Kolya3@example.com",
                                                  "username": "",
                                                  "password": "",
                                                  "phoneNumber": "+38096179945"
                                                }
                                                """
                                ),
                                @ExampleObject(
                                        name = "Not valid data",
                                        value = """
                                                {
                                                  "firstName": "Mark!",
                                                  "lastName": "",
                                                  "birthday": "",
                                                  "email": "Kolya3!example.com",
                                                  "username": "",
                                                  "password": "",
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
                        description = "User updated",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = User.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "409",
                        description = "User already exists",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ResponseExceptionHandler.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid ID",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ResponseExceptionHandler.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid data",
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
public @interface UpdateUser {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
