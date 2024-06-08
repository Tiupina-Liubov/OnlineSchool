package com.example.online_school.security.utils;

import org.springframework.http.HttpMethod;

public class AuthorizationRightsRoles {
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";
    public static final String MANAGER = "MANAGER";
    public static final String GUEST = "GUEST";


    public static final String[] ANONYMOUS_LIST = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**",
            "/favicon.ico",
            "/api/**",
            "/users/registration"

    };
    public static final String[] USER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/",
            "/webjars/**",
            "/configuration/**",
            "/public",
            "/favicon.ico",
            "/swagger-ui/**",
            "/h2-console/**",
            "/address/show_address"

    };

    public static final String[] ADMIN_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/",
            "/webjars/**",
            "/configuration/**",
            "/public",
            "/favicon.ico",
            "/swagger-ui/**",
            "/h2-console/**",
            "/department/show_department_by_name/**",
            "/event/create_event",
            "/vacancy/create_vacancy",
            "/vacancy/delete_vacancy"

    };

    public static final String[] MANAGER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/",
            "/webjars/**",
            "/configuration/**",
            "/public",
            "/favicon.ico",
            "/swagger-ui/**",
            "/h2-console/**",
            "/address/show_address/**"

    };

    public static final String[] TEACHER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/",
            "/webjars/**",
            "/configuration/**",
            "/public",
            "/favicon.ico",
            "/swagger-ui/**",
            "/h2-console/**",
            "/address/show_address/**"

    };

    public static final String[] CLASS_ROOM_TEACHER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/",
            "/webjars/**",
            "/configuration/**",
            "/public",
            "/favicon.ico",
            "/swagger-ui/**",
            "/h2-console/**",
            "/address/show_address/**"

    };
}
