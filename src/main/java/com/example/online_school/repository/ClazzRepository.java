package com.example.online_school.repository;

import com.example.online_school.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for Clazz entities.
 *
 * Интерфейс репозитория для сущностей Clazz.
 */
@Repository
public interface ClazzRepository extends JpaRepository<Clazz, UUID> {

    /**
     * Retrieves a Clazz entity by its ID.
     *
     * Получает сущность Clazz по ее идентификатору.
     *
     * @param id The ID of the Clazz entity.
     * @return The Clazz entity.
     */
    Clazz getClazzById(UUID id);
}
