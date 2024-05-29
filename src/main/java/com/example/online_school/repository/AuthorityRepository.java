package com.example.online_school.repository;

import com.example.online_school.entity.Authority;
import com.example.online_school.entity.enums.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for Authority entities.
 *
 * Интерфейс репозитория для сущностей Authority.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, UUID> {

    /**
     * Retrieves an Authority entity by its ID.
     *
     * Получает сущность Authority по ее идентификатору.
     *
     * @param id The ID of the Authority entity.
     * @return The Authority entity.
     */
    Authority getAuthorityById(UUID id);
}
