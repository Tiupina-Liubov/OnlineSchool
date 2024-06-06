package com.example.online_school.service;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

/**
 * Service interface for managing User entities.
 *
 * Интерфейс сервиса для управления сущностями User.
 */
public interface UserService  {

    /**
     * Retrieves a User entity by its ID.
     *
     * Получает сущность User по ее идентификатору.
     *
     * @param id The ID of the User entity.
     * @return The User entity.
     * @throws IdNotFoundException If the User with the provided ID is not found.
     */
    User getUserById(UUID id) throws IdNotFoundException;

    /**
     * Deletes a User entity by its ID.
     *
     * Удаляет сущность User по ее идентификатору.
     *
     * @param id The ID of the User entity.
     * @return A message indicating the deletion status.
     * @throws IdNotFoundException If the User with the provided ID is not found.
     */
    String deleteUserById(UUID id) throws IdNotFoundException;

    /**
     * Creates a new User entity based on the provided UserCreateDto.
     *
     * Создает новую сущность User на основе предоставленного UserCreateDto.
     *
     * @param userCreateDto The DTO containing information to create a new User.
     * @return The DTO containing information about the created User.
     * @throws ObjectAlreadyExistsException If a User with the provided email already exists.
     */
    UserAfterCreationDto createUser(UserCreateDto userCreateDto) throws ObjectAlreadyExistsException;

    /**
     * Updates an existing User entity based on the provided UserUpdateDto.
     *
     * Обновляет существующую сущность User на основе предоставленного UserUpdateDto.
     *
     * @param id The ID of the User entity to update.
     * @param userUpdateDto The DTO containing information to update the User.
     * @return The DTO containing information about the updated User.
     */
    UserAfterUpdateDto updateUser(UUID id, UserUpdateDto userUpdateDto);
}
