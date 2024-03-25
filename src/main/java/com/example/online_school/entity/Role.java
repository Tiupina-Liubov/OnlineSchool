package com.example.online_school.entity;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public class Role {

    private UUID id;

    private String roleName;

    private Set<Authority> authorities;

    private ZonedDateTime createAt;

    private ZonedDateTime updateAt;

}
