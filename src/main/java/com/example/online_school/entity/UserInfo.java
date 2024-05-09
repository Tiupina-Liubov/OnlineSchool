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
 * (Класс который отвечает за всю личную информацыю пользователе. )
 */
@Entity
@Getter
@Setter
@Table(name = "user_infos")
@NoArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
    type = UuidTimeSequenceGenerator.class)
    @Column(name = "user_info_id")
    private UUID id;

    /**
     * Field that is used as login when logging into the application
     */
    @Column(name = "username")
    private String username;

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

    @Column(name = "email")
    private String email;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;


//    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_info_role",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles=new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) && Objects.equals(username, userInfo.username) && Objects.equals(password, userInfo.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

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

    public void addRole(Role role) {
        if(role!=null){
            roles.add(role);
        }
    }


}


