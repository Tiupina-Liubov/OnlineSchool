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

@Entity
@Getter
@Setter
@Table(name = "clazzes")
@NoArgsConstructor
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "clazz_id")
    private UUID id;

    @Column(name = "clazz_name")
    private String name;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "clazz_subjekts",
            joinColumns = @JoinColumn(name = "clazz_id"),
            inverseJoinColumns = @JoinColumn(name = "subjekt_id")
    )
    private Set<Subjekt> subjects;// todo подумать над тем как сделать проще без этого поля

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "class_teacher_id")
    private User classRoomTeacher;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clazzId")
    private List<Lesson> lessons;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz that = (Clazz) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
