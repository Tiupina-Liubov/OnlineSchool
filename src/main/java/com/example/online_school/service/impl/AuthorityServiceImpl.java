package com.example.online_school.service.impl;

import com.example.online_school.entity.Authority;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.repository.AuthorityRepository;
import com.example.online_school.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Implementation of the AuthorityService interface.
 */
@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    /**
     * Retrieves an Authority entity by its ID.
     *
     * @param id The ID of the Authority entity.
     * @return The Authority entity.
     * @throws IdNotFoundException if no Authority entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Authority getAuthorityById(UUID id) {
        Authority authority = authorityRepository.getAuthorityById(id);

        if (authority != null) {
            return authority;
        } else {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }
}
