package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class Class {

   private UUID id;

  private   String name;

   private School school;

    private Set<User> students;

   private Set<Subject> subjects;

   private User classRoomTeacher;

    private ZonedDateTime createAt;

   private ZonedDateTime updateAt;

}
