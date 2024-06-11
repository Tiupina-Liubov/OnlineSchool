package com.example.online_school.security.utils;



public class AuthorizationRightsRoles {
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";


    public static final String[] USER_LIST = {
            "/users/**",
    };


    public static final String[] ADMIN_LIST = {
            "/roles/**",
            "/authority/**",
            "/log",
            "/user_infos/addRole"
    };


}
