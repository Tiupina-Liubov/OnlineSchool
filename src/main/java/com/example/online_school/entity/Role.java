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
 * Класс, представляющий роль в системе.
 */
@Entity
@Getter
@Setter
@Table(name = "roles")
@NoArgsConstructor
public class Role {
    /**
     * Unique identifier.
     * Уникальный идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id")
    private UUID id;

    /**
     * The name of the role.
     * Название роли.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;

    /**
     * Date and time when the role was created.
     * Дата и время создания роли.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the role was last updated.
     * Дата и время последнего обновления роли.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * Authorities associated with the role.
     * Полномочия, связанные с ролью.
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
     * Метод сравнения объектов роли.
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
     * Генерация хэш-кода для объекта роли.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, authorities);
    }

    /**
     * Returns the string representation of the Role object.
     * Возвращает строковое представление объекта роли.
     */
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
