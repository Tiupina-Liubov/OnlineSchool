package com.example.online_school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.Objects;
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

    @Column(name = "time")
    private Time time;

    @Column(name = "createAt")
    private ZonedDateTime createAt;

    @Column(name = "updateAt")
    private ZonedDateTime updateAt;

    @OneToOne()
    @JoinColumn(name = "subjekt_id")
    private Subjekt subjekt;

    @OneToOne(optional = false)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @OneToOne(optional = false)
    @JoinColumn(name = "clazz_id")
    private Clazz clazzId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(time, lesson.time) && Objects.equals(createAt, lesson.createAt) && Objects.equals(updateAt, lesson.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", time=" + time +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

}
