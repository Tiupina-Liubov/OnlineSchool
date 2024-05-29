package com.example.online_school.entity;

import com.example.online_school.entity.enums.SubjektName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * A class representing a subject within the school curriculum.
 *
 * Класс, представляющий предмет в учебном плане школы.
 */
@Entity
@Getter
@Setter
@Table(name = "subjekts")
@NoArgsConstructor
public class Subjekt {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subjekt_id")
    private UUID id;

    /**
     * The name of the subject.
     * Название предмета.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "subjekt_name")
    private SubjektName name;

    /**
     * The number of hours dedicated to the subject.
     * Количество часов, выделенных на предмет.
     */
    @Column(name = "count_hours")
    private Integer countHours;

    /**
     * Date and time when the subject was created.
     * Дата и время создания предмета.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the subject was last updated.
     * Дата и время последнего обновления предмета.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * The list of themes associated with the subject.
     * Список тем, связанных с предметом.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private List<Theme> themes;

    /**
     * Equals method for comparing Subjekt objects.
     * Метод сравнения объектов предмета.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjekt that = (Subjekt) o;
        return Objects.equals(id, that.id) && name == that.name && Objects.equals(countHours, that.countHours);
    }

    /**
     * Generates the hash code for the Subjekt object.
     * Генерация хэш-кода для объекта предмета.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, countHours);
    }

    /**
     * Returns the string representation of the Subjekt object.
     * Возвращает строковое представление объекта предмета.
     */
    @Override
    public String toString() {
        return "SchoolSubject{" +
                "id=" + id +
                ", name=" + name +
                ", countHours=" + countHours +
                '}';
    }
}
