package com.example.online_school.service.impl;

import com.example.online_school.entity.Clazz;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
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
      return   clazzRepository.getClazzById(id);

    }

    @Override
    public String deleteClazzById(UUID id) {
        Clazz clazz= clazzRepository.getClazzById(id);
        if(clazz!=null){
            clazzRepository.deleteById(id);
            return "******DELETE******";
        }else {
            throw  new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }
    }
}
