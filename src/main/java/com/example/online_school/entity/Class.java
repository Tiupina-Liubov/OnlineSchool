package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class Class {
    UUID id;
    String name;

    School school;

    Set<User> students;
    Set<Subject> subjects;
    User classRoomTeacher;
    ZonedDateTime createAt;
    ZonedDateTime updateAt;

}
