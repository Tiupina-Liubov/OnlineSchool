package com.example.online_school.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@OpenAPIDefinition(
        info = @Info(
                title = "Online School",
                description = "There is a prototype of the BackEnd Online School's Core Services data. <br />" +
                        "Data consist of  authorities, roles, users, user infos, accounts,class,lessons",
                version = "1.0.0",
                contact = @Contact(
                        name = "Liubov Tiupina",
                        url = "https://github.com/Tiupina-Liubov?tab=repositories"
                )
        )
)
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.packageName:com.example.online_school}")

    private String PACKAGE_NAME;
    public static final String ACCOUNTS = "accounts service";
    public static final String ROLES = "roles service";
    public static final String USERS = "users service";
    public static final String CLASSES = "classes service";
    public static final String LESSONS = "lessons service";
    public static final String USER_INFO = "user info service";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_NAME))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(ACCOUNTS, "API for working with accounts service"))
                .tags(new Tag(ROLES, "API for working with roles service"))
                .tags(new Tag(USERS, "API for working with users service"))
                .tags(new Tag(CLASSES, "API for working with classes service"))
                .tags(new Tag(LESSONS, "API for working with lessons service"))
                .tags(new Tag(USER_INFO, "API for working with user info service"));
    }
}
