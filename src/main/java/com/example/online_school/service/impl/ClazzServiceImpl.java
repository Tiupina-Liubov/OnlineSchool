package com.example.online_school.service.impl;

import com.example.online_school.entity.Clazz;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.repository.ClazzRepository;
import com.example.online_school.service.ClazzService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClazzServiceImpl implements ClazzService {

    private final ClazzRepository clazzRepository;

    @Override
    public Clazz getClazzById(UUID id) {
        Clazz clazz = clazzRepository.getClazzById(id);
        if (clazz == null) {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }else {
            return clazz;
        }
    }

}
