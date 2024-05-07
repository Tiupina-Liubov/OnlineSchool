package com.example.online_school.annotation;


import com.example.online_school.entity.User;
import com.example.online_school.handler.GlobalExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Show User by ID",
        description = "Retrieve an user by its unique identifier",
        tags = {"USER"},
        parameters = {
                @Parameter(
                        name = "userId",
                        description = "The unique identifier of the user",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "uuid"),
                        examples = {
                                @ExampleObject(name = "Example request with correct Id", value = "d234d99d-170e-42f7-b6ae-435ee56f49b5"),
                                @ExampleObject(name = "Example request with non-exist Id", value = "d234d99d-170e-42f7-b6ae-435ee56f49b6"),
                                @ExampleObject(name = "Example request with invalid Id", value = "invalidId")
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "User found and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = User.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid ID",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = GlobalExceptionHandler.class)
                        )
                ), @ApiResponse(
                responseCode = "409",
                description = "User not found",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = GlobalExceptionHandler.class)
                )
        )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)

public @interface GetUser {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
