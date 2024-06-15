package com.example.online_school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * A class representing a theme within the system.
 */
@Entity
@Getter
@Setter
@Table(name = "themes")
@NoArgsConstructor
public class Theme {
    /**
     * Unique identifier of the theme.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "theme_id")
    private UUID id;

    /**
     * The name of the theme.
     */
    @Column(name = "theme_name")
    private String name;

    /**
     * Date and time when the theme was created.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the theme was last updated.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * The subject to which the theme belongs.
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    /**
     * Equals method for comparing Theme objects.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return Objects.equals(id, theme.id) && Objects.equals(name, theme.name);
    }

    /**
     * Generates the hash code for the Theme object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /**
     * Returns the string representation of the Theme object.
     */
    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
