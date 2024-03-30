package com.example.online_school.entity.enums;

import com.example.online_school.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public enum TypeSchool {
    COLLEGE,//колледж
    ELEMENTARY,//начальная школа
    HIGH,// — средняя школа
    JUNIOR_COLLEGE,//колледж с двухгодичным неполным обучением
    JUNIOR_HIGH,// — младшие классы средней школы
    TECHNICAL,//техникум
    UNIVERSITY//университет
    ;

    @Entity
    @Setter
    @Getter
    @Table(name = "authorities")
    @NoArgsConstructor
    public static class Authority {

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
}
