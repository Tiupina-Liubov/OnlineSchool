package com.example.online_school.entity;

import com.example.online_school.entity.enums.TypeSchool;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "schools")
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "school_id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_schools")
    TypeSchool typeSchool;

    @Column(name = "is_open")
    private Boolean isOpen;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    Set<SchoolClass> schoolClasses;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id) && Objects.equals(name, school.name) && Objects.equals(phoneNumber, school.phoneNumber) && typeSchool == school.typeSchool;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, typeSchool);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", typeSchool=" + typeSchool +
                '}';
    }
}
