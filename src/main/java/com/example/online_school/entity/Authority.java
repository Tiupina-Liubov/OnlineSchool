package com.example.online_school.entity;

import com.example.online_school.entity.enums.AuthorityName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * This class is responsible for access rights to various files,
 * such as modification, deletion, and reading.
 */
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

    /**
     * The name of the authority.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "authority_name")
    private AuthorityName authorityName;

    /**
     * Date and time when the authority was created.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the authority was last updated.
     */
    @Column(name = "updated_at")
    private ZonedDateTime updateAt;

    /**
     * The set of roles associated with the authority.
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;

}
