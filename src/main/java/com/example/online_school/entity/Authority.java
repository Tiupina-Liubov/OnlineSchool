package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class Authority {
    UUID id;
    String authorityName;
    Set<Role> roles;
    ZonedDateTime createAt;
    ZonedDateTime updateAt;
}
