package com.example.online_school.entity;

import com.example.online_school.entity.enums.SubjectName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "school_subjects")
@NoArgsConstructor
public class SchoolSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subject_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject_name")
    private SubjectName name;

    @Column(name = "count_hours")
    private Integer countHours;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private List<Theme> themes;






}

