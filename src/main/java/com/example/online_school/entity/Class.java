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
 */
@Entity
@Getter
@Setter
@Table(name = "classes")
@NoArgsConstructor
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "class_id")
    private UUID id;

    /**
     * The name of the class.
     */
    @Column(name = "class_name")
    private String name;

    /**
     * Date and time when the class was created.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the class was last updated.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * The school to which the class belongs.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    /**
     * The set of subjects taught in the class.
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "class_subjects",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;

    /**
     * The teacher assigned to the class.
     */
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "class_teacher_id")
    private User classRoomTeacher;

    /**
     * The list of lessons associated with the class.
     */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private List<Lesson> lessons;

    /**
     * Equals method for comparing Class objects.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class that = (Class) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    /**
     * Generates the hash code for the Class object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /**
     * Returns the string representation of the Class object.
     */
    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
