package com.example.online_school.service.impl;

import com.example.online_school.entity.Class;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.repository.ClassRepository;
import com.example.online_school.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Implementation of the ClassService interface.
 */
@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository clazzRepository;

    /**
     * Retrieves a Class entity by its ID.
     *
     * @param id The ID of the Clazz entity.
     * @return The Class entity.
     * @throws IdNotFoundException if no Class entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public Class getClassById(UUID id) {
        Class clazz = clazzRepository.getClazzById(id);
        if (clazz == null) {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        } else {
            return clazz;
        }
    }
}
