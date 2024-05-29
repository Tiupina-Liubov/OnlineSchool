package com.example.online_school.service.impl;

import com.example.online_school.entity.Clazz;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.repository.ClazzRepository;
import com.example.online_school.service.ClazzService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Implementation of the ClazzService interface.
 *
 * Реализация интерфейса ClazzService.
 */
@Service
@RequiredArgsConstructor
public class ClazzServiceImpl implements ClazzService {

    private final ClazzRepository clazzRepository;

    /**
     * Retrieves a Clazz entity by its ID.
     *
     * Получает сущность Clazz по ее идентификатору.
     *
     * @param id The ID of the Clazz entity.
     * @return The Clazz entity.
     * @throws IdNotFoundException if no Clazz entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public Clazz getClazzById(UUID id) {
        Clazz clazz = clazzRepository.getClazzById(id);
        if (clazz == null) {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        } else {
            return clazz;
        }
    }
}
