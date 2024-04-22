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

    @Enumerated(EnumType.STRING)
    @Column(name = "subjekt_name")
    private SubjektName name;

    @Column(name = "count_hours")
    private Integer countHours;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private List<Theme> themes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjekt that = (Subjekt) o;
        return Objects.equals(id, that.id) && name == that.name && Objects.equals(countHours, that.countHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countHours);
    }

    @Override
    public String toString() {
        return "SchoolSubject{" +
                "id=" + id +
                ", name=" + name +
                ", countHours=" + countHours +
                '}';
    }
}
