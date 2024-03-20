package com.example.online_school.entity;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Lesson {
    UUID id;
    Subject subject;
    Time time;
    User teacher;
    Class classId;
    ZonedDateTime createAt;
    ZonedDateTime updateAt;

}
