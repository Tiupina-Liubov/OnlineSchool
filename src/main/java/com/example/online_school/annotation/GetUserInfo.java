package com.example.online_school.annotation;

import com.example.online_school.entity.UserInfo;
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

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Show user info by ID",
        description = "Retrieve an user info by its unique identifier",
        tags = {"USER_INFO"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the user info",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "uuid"),
                        examples = {
                                @ExampleObject(
                                        name = "Example request with correct Id",
                                        value = "a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de"
                                ),
                                @ExampleObject(
                                        name = "Example request with non-exist Id",
                                        value = "55035fe9-37e3-466f-ba4a-197f23fc5707"
                                ),
                                @ExampleObject(
                                        name = "Example request with invalid Id",
                                        value = "d234d99d-170e-42f7-aa6ae-435ee56f49b5"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "User info found and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserInfo.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid ID",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ResponseExceptionHandler.class)//todo решить вопрос с не валидними даними
                        )
                ), @ApiResponse(
                responseCode = "409",
                description = "User info not found",
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

public @interface GetUserInfo {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}