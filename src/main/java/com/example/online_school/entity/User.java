package com.example.online_school.entity;

import com.example.online_school.generatorUuid.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * This class represents a user within the system.
 * It stores publicly available information about the user
 * throughout the application.
 *
 * Этот класс представляет пользователя в системе.
 * В нем хранится общедоступная информация о пользователе
 * на протяжении всего приложения.
 *
 * @author Tiupina Liubov
 */
@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User {

    /**
     * Unique identifier of the user.
     * Уникальный идентификатор пользователя.
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "user_id")
    private UUID id;

    /**
     * First name of the user.
     * Имя пользователя.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Last name of the user.
     * Фамилия пользователя.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Birthday of the user.
     * Дата рождения пользователя.
     */
    @Column(name = "birthday")
    private LocalDate birthday;

    /**
     * Date and time when the user was created.
     * Дата и время создания пользователя.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the user was last updated.
     * Дата и время последнего обновления пользователя.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * The class to which the user belongs.
     * Класс, к которому принадлежит пользователь.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz schoolClass;

    /**
     * Additional information about the user.
     * Дополнительная информация о пользователе.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    /**
     * Equals method for comparing User objects.
     * Метод сравнения объектов пользователей.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(birthday, user.birthday) && Objects.equals(createAt, user.createAt) && Objects.equals(updateAt, user.updateAt);
    }

    /**
     * Generates the hash code for the User object.
     * Генерация хэш-кода для объекта пользователя.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthday, createAt, updateAt);
    }

    /**
     * Returns the string representation of the User object.
     * Возвращает строковое представление объекта пользователя.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
