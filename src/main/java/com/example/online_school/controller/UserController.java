package com.example.online_school.controller;

import com.example.online_school.annotation.*;
import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class responsible for handling user-related HTTP requests.
 *
 * Класс контроллера, отвечающий за обработку HTTP-запросов, связанных с пользователями.
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Retrieves user information by its ID.
     *
     * Получает информацию о пользователе по его идентификатору.
     *
     * @param id The ID of the user to retrieve.
     *           Идентификатор пользователя для извлечения.
     * @return The user object.
     *         Объект пользователя.
     */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetUser(path = "/{id}")
    public User getUserById(@UuidFormatChecker @PathVariable("id") String id) {
        return userService.getUserById(UUID.fromString(id));
    }

    /**
     * Deletes a user by its ID.
     *
     * Удаляет пользователя по его идентификатору.
     *
     * @param id The ID of the user to delete.
     *           Идентификатор пользователя для удаления.
     * @return A message indicating the success of the operation.
     *         Сообщение, указывающее на успешность операции.
     */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteUser(path = "/delete/{id}")
    public String deleteUserByID(@UuidFormatChecker @PathVariable("id") String id) {

        return userService.deleteUserById(UUID.fromString(id));
    }

    /**
     * Updates a user's information.
     *
     * Обновляет информацию о пользователе.
     *
     * @param id The ID of the user to update.
     *           Идентификатор пользователя для обновления.
     * @param userUpdateDto The DTO containing the updated user information.
     *                      DTO, содержащий обновленную информацию о пользователе.
     * @return The DTO containing the updated user information.
     *         DTO, содержащий обновленную информацию о пользователе.
     */
    @PreAuthorize("hasRole('USER')")
    @UpdateUser(path = "/update/{id}/")
    public UserAfterUpdateDto updateUser( @UuidFormatChecker @PathVariable("id") String id, @Valid @RequestBody UserUpdateDto userUpdateDto) {//todo не роботает коректно @Valid при обновлении даных
        return userService.updateUser(UUID.fromString(id), userUpdateDto);
    }

    /**
     * Creates a new user.
     *
     * Создает нового пользователя.
     *
     * @param userCreateDto The DTO containing the information for creating the new user.
     *                      DTO, содержащий информацию для создания нового пользователя.
     * @return The DTO containing the information of the newly created user.
     *         DTO, содержащий информацию о только что созданном пользователе.
     * @throws ObjectAlreadyExistsException if a user with the same details already exists.
     *                                      если пользователь с такими же данными уже существует.
     */
    @PermitAll//todo
    @CreateUser(path = "/registration")
    public UserAfterCreationDto createUser(@Valid @RequestBody UserCreateDto userCreateDto) throws ObjectAlreadyExistsException {
        return userService.createUser(userCreateDto);
    }
}


