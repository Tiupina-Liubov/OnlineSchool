package com.example.online_school.entity;

import com.example.online_school.entity.enums.TypeSchool;

import java.time.ZonedDateTime;
import java.util.UUID;

public class School {

    private UUID id;

    private String name;

    private String link;

    private String phoneNumber;

    private String address;

// Enum<TypeSchool> typeSchool;

    private boolean isOpen;


    private ZonedDateTime createAt;

    private ZonedDateTime updateAt;


}
