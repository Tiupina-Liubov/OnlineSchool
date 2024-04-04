package com.example.online_school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * A class that is responsible for all personal information about the user.
 * (Класс который отвечает за всю личную информацыю пользователе. )
 */
@Entity
@Getter
@Setter
@Table(name = "user_infos")
@NoArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_info_id")
    private UUID id;

    /**
     * Field that is used as login when logging into the application
     */
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;
    /**
     * Field that is used as password when logging into the application
     */
    @Column(name = "password")
    private String password;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "payment_tribute")
    private String paymentTribute;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @OneToOne(mappedBy = "userInfo")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_info_role",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) && Objects.equals(username, userInfo.username) && Objects.equals(email, userInfo.email) && Objects.equals(password, userInfo.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", paymentTribute='" + paymentTribute + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}


