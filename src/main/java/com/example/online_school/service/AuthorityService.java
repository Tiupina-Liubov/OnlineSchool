package com.example.online_school.service;

import com.example.online_school.entity.Authority;

import java.util.UUID;

/**
 * Service interface for managing Authority entities.
 *
 * Интерфейс сервиса для управления сущностями Authority.
 */
public interface AuthorityService {

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
