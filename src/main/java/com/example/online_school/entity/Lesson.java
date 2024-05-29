package com.example.online_school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * A class representing a lesson within the school.

 * Класс, представляющий урок в школе.
 */
@Entity
@Getter
@Setter
@Table(name = "lessons")
@NoArgsConstructor
public class Lesson {
    /**
     * Unique identifier of the lesson.
     * Уникальный идентификатор урока.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "lesson_id")
    private UUID id;

    /**
     * The time of the lesson.
     * Время урока.
     */
    @Column(name = "time")
    private Time time;

    /**
     * Date and time when the lesson was created.
     * Дата и время создания урока.
     */
    @Column(name = "createAt")
    private ZonedDateTime createAt;

    /**
     * Date and time when the lesson was last updated.
     * Дата и время последнего обновления урока.
     */
    @Column(name = "updateAt")
    private ZonedDateTime updateAt;

    /**
     * The subject of the lesson.
     * Предмет урока.
     */
    @OneToOne()
    @JoinColumn(name = "subjekt_id")
    private Subjekt subjekt;

    /**
     * The teacher conducting the lesson.
     * Учитель, проводящий урок.
     */
    @OneToOne(optional = false)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    /**
     * The class to which the lesson belongs.
     * Класс, к которому относится урок.
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Clazz classId;

    /**
     * Equals method for comparing Lesson objects.
     * Метод сравнения объектов урока.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(time, lesson.time) && Objects.equals(createAt, lesson.createAt) && Objects.equals(updateAt, lesson.updateAt);
    }

    /**
     * Generates the hash code for the Lesson object.
     * Генерация хэш-кода для объекта урока.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, time, createAt, updateAt);
    }

    /**
     * Returns the string representation of the Lesson object.
     * Возвращает строковое представление объекта урока.
     */
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
