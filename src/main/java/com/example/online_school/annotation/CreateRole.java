//package com.example.online_school.annotation;
//
//import com.example.online_school.entity.Role;
//import com.example.online_school.entity.User;
//import com.example.online_school.exception.ObjectAlreadyExistsException;
//import com.example.online_school.handler.ResponseExceptionHandler;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.enums.ParameterIn;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.ExampleObject;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import org.springframework.core.annotation.AliasFor;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
//@RequestMapping(method = RequestMethod.POST)
//@Operation(
//        summary = "Create new role",
//        description = "Create new role and return him",
//        tags = {"ROLE"},
//        requestBody = @RequestBody(
//                description = "The role to be created",
//                required = true,
//                content = @Content(
//                        mediaType = "application/json",
//                        schema = @Schema(implementation = Role.class),
//                        examples = {@ExampleObject(name = "Good request",
//                                value = """
//                                        {
//
//                                        }
//                                        """
//                        ),
//                                @ExampleObject(name = "Request with existing email",
//                                        value = """
//                                        {
//
//                                        """ )}
//                )
//        ),
//        responses = {
//                @ApiResponse(
//                        responseCode = "200",
//                        description = "User created",
//                        content = @Content(
//                                mediaType = "application/json",
//                                schema = @Schema(implementation = User.class)
//                        )
//                ),
//                @ApiResponse(
//                        responseCode = "409",
//                        description = "User already exist",
//                        content = @Content(
//                                mediaType = "application/json",
//                                schema = @Schema(implementation = ResponseExceptionHandler.class)
//                        )
//                )
//        },
//        security = {
//                @SecurityRequirement(name = "safety requirements")
//        }
//)
//
//
//public @interface CreateRole {
//    @AliasFor(annotation = RequestMapping.class,attribute = "path")
//    String [] path() default {};
//}
