package com.example.online_school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * A class representing a class within the school.
 *
 * Класс, представляющий класс в школе.
 */
@Entity
@Getter
@Setter
@Table(name = "classes")
@NoArgsConstructor
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "class_id")
    private UUID id;

    /**
     * The name of the class.
     * Название класса.
     */
    @Column(name = "class_name")
    private String name;

    /**
     * Date and time when the class was created.
     * Дата и время создания класса.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the class was last updated.
     * Дата и время последнего обновления класса.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * The school to which the class belongs.
     * Школа, к которой принадлежит класс.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    /**
     * The set of subjects taught in the class.
     * Набор предметов, преподаваемых в классе.
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "class_subjekts",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "subjekt_id")
    )
    private Set<Subjekt> subjects;

    /**
     * The teacher assigned to the class.
     * Преподаватель, назначенный на класс.
     */
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "class_teacher_id")
    private User classRoomTeacher;

    /**
     * The list of lessons associated with the class.
     * Список уроков, связанных с классом.
     */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private List<Lesson> lessons;

    /**
     * Equals method for comparing Clazz objects.
     * Метод сравнения объектов класса.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz that = (Clazz) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    /**
     * Generates the hash code for the Clazz object.
     * Генерация хэш-кода для объекта класса.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /**
     * Returns the string representation of the Clazz object.
     * Возвращает строковое представление объекта класса.
     */
    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
