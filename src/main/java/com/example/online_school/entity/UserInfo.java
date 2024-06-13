package com.example.online_school.entity;

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
 */
@Entity
@Getter
@Setter
@Table(name = "user_infos")
@NoArgsConstructor
public class UserInfo {
    /**
     * Unique identifier.
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "com.example.online_school.generatorUuid.UuidTimeSequenceGenerator")
    @Column(name = "user_info_id")
    private UUID id;

    /**
     * Field that is used as login when logging into the application.
     */
    @Column(name = "username")
    private String username;

    /**
     * Field that is used as password when logging into the application.
     */
    @Column(name = "password")
    private String password;

    /**
     * Salary of the user.
     */
    @Column(name = "salary")
    private BigDecimal salary;

    /**
     * Payment tribute of the user.
     */
    @Column(name = "payment_tribute")
    private String paymentTribute;

    /**
     * Phone number of the user.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Email address of the user.
     */
    @Column(name = "email")
    private String email;

    /**
     * Date and time when the user info was created.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the user info was last updated.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * Roles associated with the user.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_info_role",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    /**
     * Equals method for comparing UserInfo objects.
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
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    /**
     * Returns the string representation of the UserInfo object.
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

}
