package com.example.online_school.service.impl;

import com.example.online_school.entity.Authority;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.repository.AuthorityRepository;
import com.example.online_school.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    private final AuthorityMapper authorityMapper;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Authority getAuthorityById(UUID id) {
        Authority authority = authorityRepository.getAuthorityById(id);

        if (authority != null) {
            return authority;

        } else {
            throw new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }
    }

}
