package com.example.online_school.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
    @RequestMapping(method = RequestMethod.DELETE)
    @Operation(
            summary = "Delete user by ID",
            description = "Delete an existing user by its unique identifier",
            tags = {"USER"},
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique identifier of the user",
                            required = true,
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "string", format = "uuid"),
                            examples = {
                                    @ExampleObject(
                                            name = "Example existing Id",
                                            value = "d234d99d-170e-42f7-b6ae-435ee56f49b5"
                                    ),
                                    @ExampleObject(
                                            name = "Example non-existing Id",
                                            value = "55035fe9-37e3-466f-ba4a-197f23fc5701"
                                    )
                            }
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User removed"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User does not exist"
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    public @interface DeleteUser {
        @AliasFor(annotation = RequestMapping.class, attribute = "path")
        String[] path() default {};
    }

