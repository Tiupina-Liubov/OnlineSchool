package com.example.online_school.service;

import com.example.online_school.entity.Clazz;

import java.util.UUID;

/**
 * Service interface for managing Clazz entities.
 *
 * Интерфейс сервиса для управления сущностями Clazz.
 */
public interface ClazzService {

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
