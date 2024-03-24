package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Subject {

    private UUID id;

    private String name;

    private int countHours;

    private List<Theme> themes;

    private ZonedDateTime createAt;

    private ZonedDateTime updateAt;

}
