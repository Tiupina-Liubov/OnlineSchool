package com.example.online_school.repository;

import com.example.online_school.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for Class entities.
 */
@Repository
public interface ClassRepository extends JpaRepository<Class, UUID> {

    /**
     * Retrieves a Class entity by its ID.
     *
     * @param id The ID of the Class entity.
     * @return The Class entity.
     */
    Class getClazzById(UUID id);
}
