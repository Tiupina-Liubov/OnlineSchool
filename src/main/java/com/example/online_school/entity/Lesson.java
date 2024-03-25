package com.example.online_school.entity;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Lesson {

    private UUID id;

    private Subject subject;

    private Time time;

    private User teacher;

    private Class classId;

    private ZonedDateTime createAt;

    private ZonedDateTime updateAt;


}
