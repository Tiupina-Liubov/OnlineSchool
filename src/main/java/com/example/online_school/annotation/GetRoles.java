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
 * Annotation to define a method as a GET endpoint to retrieve roles by their unique identifiers.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Show roles",
        description = "Retrieve an role by its unique identifier",
        tags = {"ROLE"},
        parameters = {
                @Parameter(
                        name = "roles",
                        description = "The unique identifier of the role",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Example request with correct"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Roles found and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(type = "array", implementation = Role.class)
                        )
                ), @ApiResponse(
                responseCode = "409",
                description = "Roles not found",
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

public @interface GetRoles {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};

}

