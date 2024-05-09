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
        summary = "Delete role by ID",
        description = "Delete an existing role by its unique identifier",
        tags = {"ROLE"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the role",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "uuid"),
                        examples = {
                                @ExampleObject(
                                        name = "Example existing Id",
                                        value = "6e01b191-453c-4464-998f-a671619e89de"
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
                        description = "Role removed"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Role does not exist"
                )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface DeleteRole {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}

