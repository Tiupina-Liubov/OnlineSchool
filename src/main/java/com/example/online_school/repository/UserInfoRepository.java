package com.example.online_school.repository;

import com.example.online_school.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for UserInfo entities.
 *
 * Интерфейс репозитория для сущностей UserInfo.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {

    /**
     * Retrieves a UserInfo entity by its ID.
     *
     * Получает сущность UserInfo по ее идентификатору.
     *
     * @param id The ID of the UserInfo entity.
     * @return The UserInfo entity.
     */
    UserInfo getUserInfoById(UUID id);

    /**
     * Finds a UserInfo entity by its email.
     *
     * Находит сущность UserInfo по ее адресу электронной почты.
     *
     * @param email The email of the user.
     * @return The UserInfo entity.
     */
    UserInfo findUserByEmail(String email);
}
