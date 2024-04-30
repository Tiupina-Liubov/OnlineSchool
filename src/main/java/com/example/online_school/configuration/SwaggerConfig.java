package com.example.online_school.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
        info = @Info(
                title = "Online School",
                description = "There is a prototype of the BackEnd Online School's Core Services data. <br />" +
                        "Data consist of  authorities, roles, users, user infos, accounts,class,lessons" ,
                version = "1.0.0",
                contact = @Contact(
                        name = "Liubov Tiupina",
                        url = "https://github.com/Tiupina-Liubov?tab=repositories"
                )
        )
)
public class SwaggerConfig {
}
