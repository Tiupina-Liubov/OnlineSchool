package com.example.online_school.controller;

import com.example.online_school.annotation.GetAuthority;
import com.example.online_school.annotation.UuidFormatChecker;
import com.example.online_school.entity.Authority;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class responsible for handling authority-related HTTP requests.

 * Класс контроллера, отвечающий за обработку HTTP-запросов, связанных с авторизацией.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/authority")
public class AuthorityController {

    private final AuthorityService authorityService;

    /**
     * Retrieves authority information by its ID.

     * Получает информацию об авторизации по ее идентификатору.
     *
     * @param id The ID of the authority to retrieve.
     *           Идентификатор авторизации для извлечения.
     * @return The authority object.
     *         Объект авторизации.
     * @throws IdNotFoundException if the provided ID does not exist.
     *                             если предоставленный идентификатор не существует.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetAuthority(path = "/{id}")
    public Authority getAuthorityById(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
        return authorityService.getAuthorityById(UUID.fromString(id));
    }

}
