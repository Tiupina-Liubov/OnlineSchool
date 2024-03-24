package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;


public class Authority {

   private UUID id;

   private String authorityName;

   private Set<Role> roles;

  private   ZonedDateTime createAt;

   private ZonedDateTime updateAt;

}

