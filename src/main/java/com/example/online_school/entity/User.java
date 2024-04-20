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
@Table(name = "users")
@NoArgsConstructor
/**
 *This class is responsible for creating new system users.
 *This class will contain publicly available information about
 * the user throughout the entire process.
 * (Этот класс отвечает за создание нових пользователей системы.
 * В этом классе будет находитьса общедоступная информацыя о пользевотеле во всем преложение.)
 */
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clazz_id")
    private Clazz schoolClass;


    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(age, user.age) && Objects.equals(email, user.email) && Objects.equals(createAt, user.createAt) && Objects.equals(updateAt, user.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, email, createAt, updateAt);
    }
}
