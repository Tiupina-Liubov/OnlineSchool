package com.example.online_school.entity;

import com.example.online_school.entity.enums.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * A class representing a role within the system.
 */
@Entity
@Getter
@Setter
@Table(name = "roles")
@NoArgsConstructor
public class Role {
    /**
     * Unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id")
    private UUID id;

    /**
     * The name of the role.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;

    /**
     * Date and time when the role was created.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the role was last updated.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * Authorities associated with the role.
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "role_authorities",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities= new HashSet<>();

    /**
     * Equals method for comparing Role objects.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && roleName == role.roleName && Objects.equals(authorities, role.authorities);
    }

    /**
     * Generates the hash code for the Role object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, authorities);
    }

    /**
     * Returns the string representation of the Role object.
     */
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
