package com.example.online_school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.UUID;
@Entity
@Getter
@Setter
@Table(name = "lessons")
@NoArgsConstructor
public class Lesson {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "lesson_id")
    private UUID id;

    private Subject subject;

    private Time time;

    private User teacher;

    private SchoolClass classId;

    private ZonedDateTime createAt;

    private ZonedDateTime updateAt;


}
