package com.example.online_school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "school_classes")
@NoArgsConstructor
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "class_id")
    private UUID id;

    @Column(name = "class_name")
    private String name;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolClass")
    private Set<User> students;

    @ManyToMany
    @JoinTable(
            name = "school_class_subject",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;


    private User classRoomTeacher;// todo Не могу понят как сделать



}
