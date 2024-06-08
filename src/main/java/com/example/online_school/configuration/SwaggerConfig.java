package com.example.online_school.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Swagger API documentation.
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Online School",
                description = "There is a prototype of the BackEnd Online School's Core Services data. <br />" +
                        "Data consist of  authorities, roles, users, user infos,class,lessons",
                version = "1.0.0",
                contact = @Contact(
                        name = "Liubov Tiupina",
                        url = "https://github.com/Tiupina-Liubov?tab=repositories"
                )
        )
)
@Configuration
public class SwaggerConfig {
    @Value("${swagger.packageName:com.example.online_school}")
    private String PACKAGE_NAME;

    public static final String ROLE = "roles service";
    public static final String USER = "users service";
    public static final String CLASS = "classes service";
    public static final String LESSON = "lessons service";
    public static final String USER_INFO = "user info service";
    public static final String AUTHORITY = "authority service";

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan(PACKAGE_NAME)
                .addOpenApiCustomiser(openApi -> {
                    openApi.addTagsItem(new Tag().name(ROLE).description("API for working with roles service"));
                    openApi.addTagsItem(new Tag().name(USER).description("API for working with users service"));
                    openApi.addTagsItem(new Tag().name(CLASS).description("API for working with classes service"));
                    openApi.addTagsItem(new Tag().name(LESSON).description("API for working with lessons service"));
                    openApi.addTagsItem(new Tag().name(USER_INFO).description("API for working with user info service"));
                    openApi.addTagsItem(new Tag().name(AUTHORITY).description("API for working with authority service"));
                })
                .build();
    }

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                    .components(new io.swagger.v3.oas.models.Components()
                            .addSecuritySchemes("basicAuth", new SecurityScheme()
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("basic")));
        }
}
