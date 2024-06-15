package com.example.online_school.service;

import com.example.online_school.entity.Class;

import java.util.UUID;

/**
 * Service interface for managing Class entities.

 */
public interface ClassService {

    /**
     * Retrieves a Class entity by its ID.
     * @param id The ID of the Clazz entity.
     * @return The Class entity.
     */
    Class getClassById(UUID id);

}
