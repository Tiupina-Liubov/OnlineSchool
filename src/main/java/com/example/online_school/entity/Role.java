package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class Role {
    UUID id;
    String roleName;
    Set<Authority> authoritys;
    ZonedDateTime createAt;
    ZonedDateTime updateAt;
}
