package com.example.online_school.entity;

import com.example.online_school.entity.enums.AuthorityName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "authorities")
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "authority_id")
    private UUID id;

    @Column(name = "authority_name")
    private AuthorityName authorityName;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;

}

