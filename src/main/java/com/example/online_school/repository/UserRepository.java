package com.example.online_school.repository;

import com.example.online_school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Retrieves a User entity by its ID.
     *
     * @param id The ID of the User entity.
     * @return The User entity.
     */
    User getUserById(UUID id);

}
