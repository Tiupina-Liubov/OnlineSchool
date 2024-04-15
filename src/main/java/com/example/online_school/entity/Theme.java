package com.example.online_school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "themes")
@NoArgsConstructor
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "theme_id")
    private UUID id;

    @Column(name = "theme_name")
    private String name;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subjekt_id")
    private Subjekt subject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return Objects.equals(id, theme.id) && Objects.equals(name, theme.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
