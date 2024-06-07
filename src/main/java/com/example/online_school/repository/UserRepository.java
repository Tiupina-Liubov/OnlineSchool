package com.example.online_school.repository;

import com.example.online_school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Repository interface for User entities.
 *
 * Интерфейс репозитория для сущностей User.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Retrieves a User entity by its ID.
     *
     * Получает сущность User по ее идентификатору.
     *
     * @param id The ID of the User entity.
     * @return The User entity.
     */
    User getUserById(UUID id);

    /**
     * Finds all email addresses stored in the UserInfo entities.
     *
     * Находит все адреса электронной почты, хранящиеся в сущностях UserInfo.
     *
     * @return A set of email addresses.
     */
    @Query("SELECT email from UserInfo ")
    Optional<Set<String>> findAllEmail();

    /**
     * Finds all usernames stored in the UserInfo entities.
     *
     * Находит все имена пользователей, хранящиеся в сущностях UserInfo.
     *
     * @return A set of usernames.
     */
    @Query("SELECT username from UserInfo ")
    Optional<Set<String>> findAllUsername();


    Optional<User> findByUserInfo_Username(String username);
}
