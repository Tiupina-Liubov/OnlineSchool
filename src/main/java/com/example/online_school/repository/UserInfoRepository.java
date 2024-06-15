package com.example.online_school.repository;

import com.example.online_school.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for UserInfo entities.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {

    /**
     * Retrieves a UserInfo entity by its ID.
     *
     * @param id The ID of the UserInfo entity.
     * @return The UserInfo entity.
     */
    UserInfo getUserInfoById(UUID id);

    /**
     * Finds a UserInfo entity by its email.
     *
     * @param email The email of the user.
     * @return The UserInfo entity.
     */
    UserInfo findUserByEmail(String email);

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user to find
     * @return an {@code Optional} containing the {@code UserInfo} if found, or an empty {@code Optional} if not found
     */
    Optional<UserInfo> findUserByUsername(String username);
}
