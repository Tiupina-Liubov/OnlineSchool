package com.example.online_school.controller;

import com.example.online_school.annotation.GetClass;
import com.example.online_school.annotation.UuidFormatChecker;
import com.example.online_school.entity.Clazz;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.service.ClazzService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class responsible for handling class-related HTTP requests.
 *
 * Класс контроллера, отвечающий за обработку HTTP-запросов, связанных с классами.
 */
@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClazzController {

    private final ClazzService clazzService;

    /**
     * Retrieves class information by its ID.
     * Получает информацию о классе по его идентификатору.
     *
     * @param id The ID of the class to retrieve.
     *           Идентификатор класса для извлечения.
     * @return The class object.
     *         Объект класса.
     * @throws IdNotFoundException if the provided ID does not exist.
     *                             если предоставленный идентификатор не существует.
     */
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'MANAGER', 'STUDENT')")
    @GetClass(path = "/{id}")
    public Clazz getClazzById(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
        return clazzService.getClazzById(UUID.fromString(id));
    }

}
