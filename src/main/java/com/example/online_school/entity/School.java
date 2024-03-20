package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.UUID;

public class School {
    UUID id;
    String name;
    String link;
    String phoneNumber;
    String address;
    Enum TypeSchool;
    boolean isOpen;
    ZonedDateTime createAt;
    ZonedDateTime updateAt;

}
