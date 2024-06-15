package com.example.online_school.annotation;

import com.example.online_school.entity.Role;
import com.example.online_school.handler.ResponseExceptionHandler;
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
/**
 * Annotation to define a method as a GET endpoint to retrieve a role by its ID.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Show role by ID",
        description = "Retrieve an role by its unique identifier",
        tags = {"ROLE"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the role",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Example request with correct Id",
                                        value = "6e01b191-453c-4464-998f-a671619e89de"
                                ),
                                @ExampleObject(
                                        name = "Example request with non-exist Id",
                                        value = "55035fe9-37e3-466f-ba4a-197f23fc5701"
                                ),
                                @ExampleObject(
                                        name = "Example request with invalid Id",
                                        value = "d234d99d-!70e-42f7-aa6ae-435ee56f49b5"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Role found and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Role.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid ID",
                        content = @Content(
                                mediaType = "application/problem+json",
                                schema = @Schema(implementation = ResponseExceptionHandler.class)
                        )
                ),
                @ApiResponse(
                responseCode = "409",
                description = "Role not found",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema( implementation = ResponseExceptionHandler.class)
                )
        )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)

public @interface GetRole {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};

}
