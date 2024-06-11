package com.example.online_school.controller;

import com.example.online_school.annotation.GetClass;
import com.example.online_school.annotation.UuidFormatChecker;
import com.example.online_school.entity.Clazz;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.service.ClazzService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class responsible for handling class-related HTTP requests.
 */
@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClazzController {

    private final ClazzService clazzService;

    /**
     * Retrieves class information by its ID.
     *
     * @param id The ID of the class to retrieve.
     * @return The class object.
     * @throws IdNotFoundException if the provided ID does not exist.
     */
    @PreAuthorize("hasAnyRole('STUDENT', 'TEACHER', 'ADMIN')")
    @GetClass(path = "/{id}")
    public Clazz getClazzById(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
        return clazzService.getClazzById(UUID.fromString(id));
    }

}
