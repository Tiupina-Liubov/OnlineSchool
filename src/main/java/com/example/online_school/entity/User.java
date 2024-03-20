package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.UUID;

public class User {
    UUID id;
    String firstName;
    String lastName;
    int age;
    School school;
    ZonedDateTime createAt;
    ZonedDateTime updateAt;
}
