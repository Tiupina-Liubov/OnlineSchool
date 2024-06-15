package com.example.online_school.entity;

import com.example.online_school.entity.enums.SubjectName;
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
 */
@Entity
@Getter
@Setter
@Table(name = "subjects")
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subject_id")
    private UUID id;

    /**
     * The name of the subject.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "subject_name")
    private SubjectName name;

    /**
     * The number of hours dedicated to the subject.
     */
    @Column(name = "count_hours")
    private Integer countHours;

    /**
     * Date and time when the subject was created.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the subject was last updated.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * The list of themes associated with the subject.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private List<Theme> themes;

    /**
     * Equals method for comparing Subject objects.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject that = (Subject) o;
        return Objects.equals(id, that.id) && name == that.name && Objects.equals(countHours, that.countHours);
    }

    /**
     * Generates the hash code for the Subject object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, countHours);
    }

    /**
     * Returns the string representation of the Subject object.
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
