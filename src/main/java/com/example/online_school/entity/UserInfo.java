package com.example.online_school.entity;

import com.example.online_school.entity.enums.RoleName;
import com.example.online_school.generatorUuid.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * A class that is responsible for all personal information about the user.
 *
 * Класс, который отвечает за всю личную информацию о пользователе.
 */
@Entity
@Getter
@Setter
@Table(name = "user_infos")
@NoArgsConstructor
public class UserInfo {
    /**
     * Unique identifier.
     * Уникальный идентификатор.
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "com.example.online_school.generatorUuid.UuidTimeSequenceGenerator")
    @Column(name = "user_info_id")
    private UUID id;

    /**
     * Field that is used as login when logging into the application.
     * Поле, которое используется в качестве логина при входе в приложение.
     */
    @Column(name = "username")
    private String username;

    /**
     * Field that is used as password when logging into the application.
     * Поле, которое используется в качестве пароля при входе в приложение.
     */
    @Column(name = "password")
    private String password;

    /**
     * Salary of the user.
     * Зарплата пользователя.
     */
    @Column(name = "salary")
    private BigDecimal salary;

    /**
     * Payment tribute of the user.
     * Платежные взносы пользователя.
     */
    @Column(name = "payment_tribute")
    private String paymentTribute;

    /**
     * Phone number of the user.
     * Номер телефона пользователя.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Email address of the user.
     * Email адрес пользователя.
     */
    @Column(name = "email")
    private String email;

    /**
     * Date and time when the user info was created.
     * Дата и время создания информации о пользователе.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the user info was last updated.
     * Дата и время последнего обновления информации о пользователе.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * Roles associated with the user.
     * Роли, связанные с пользователем.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_info_role",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    /**
     * Equals method for comparing UserInfo objects.
     * Метод сравнения объектов информации о пользователе.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) && Objects.equals(username, userInfo.username) && Objects.equals(password, userInfo.password);
    }

    /**
     * Generates the hash code for the UserInfo object.
     * Генерация хэш-кода для объекта информации о пользователе.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    /**
     * Returns the string representation of the UserInfo object.
     * Возвращает строковое представление объекта информации о пользователе.
     */
    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", paymentTribute='" + paymentTribute + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    /**
     * Adds a role to the set of roles associated with the user.
     * Добавляет роль в набор ролей, связанных с пользователем.
     */
    public void addRole(Role role) {
        if (role != null) {
            roles.add(role);
        }
    }
}
