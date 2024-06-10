package com.example.online_school.security.utils;

import org.springframework.http.HttpMethod;

public class AuthorizationRightsRoles {
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";
    public static final String TEACHER = "TEACHER";
    public static final String STUDENT = "STUDENT";


    public static final String[] USER_LIST = {
            "/users/**",
    };


    public static final String[] ADMIN_LIST = {
            "/roles/**",
            "/authority/**",
            "/class/**",
            "/log",
            "/user_infos/addRole"
    };

    public static final String[] TEACHER_LIST = {
            "/class/**"
    };

    public static final String[] STUDENT_LIST = {
            "/class/**"
    };

}
