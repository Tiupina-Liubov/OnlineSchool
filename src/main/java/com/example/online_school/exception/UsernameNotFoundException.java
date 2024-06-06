package com.example.online_school.exception;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException (String message) {
        super(message);
}
}
