package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.UUID;

public class User {

    private UUID id;

    private String firstName;

    private String lastName;

    private int age;

    private School school;

    private ZonedDateTime createAt;

    private ZonedDateTime updateAt;
}
