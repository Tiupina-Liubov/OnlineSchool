package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Subject {
    UUID id;
    String name;
    int countHours;
    List<Theme> themes;
    ZonedDateTime createAt;
    ZonedDateTime updateAt;

}
