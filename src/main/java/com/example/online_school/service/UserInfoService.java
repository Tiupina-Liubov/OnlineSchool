package com.example.online_school.service;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoAfterUpdateDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.dto.UserInfoUpdateDto;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;

import java.util.UUID;

/**
 * Service interface for managing UserInfo entities.
 *
 * Интерфейс сервиса для управления сущностями UserInfo.
 */
public interface UserInfoService {

    /**
     * Retrieves a UserInfo entity by its ID.
     *
     * Получает сущность UserInfo по ее идентификатору.
     *
     * @param id The ID of the UserInfo entity.
     * @return The UserInfo entity.
     */
    UserInfo getUserInfoById(UUID id);

    /**
     * Creates a new UserInfo entity based on the provided UserInfoCreateDto.
     *
     * Создает новую сущность UserInfo на основе предоставленного UserInfoCreateDto.
     *
     * @param userCreateDto The DTO containing information to create a new UserInfo.
     * @return The DTO containing information about the created UserInfo.
     * @throws ObjectAlreadyExistsException If a UserInfo with the provided email already exists.
     */
    UserInfoAfterCreationDto createUserInfo(UserInfoCreateDto userCreateDto) throws ObjectAlreadyExistsException;

    /**
     * Updates an existing UserInfo entity based on the provided UserInfoUpdateDto.
     *
     * Обновляет существующую сущность UserInfo на основе предоставленного UserInfoUpdateDto.
     *
     * @param uuid The ID of the UserInfo entity to update.
     * @param userUpdateDto The DTO containing information to update the UserInfo.
     * @return The DTO containing information about the updated UserInfo.
     * @throws ObjectNotFoundException If the UserInfo with the provided ID is not found.
     */
    UserInfoAfterUpdateDto updateUserInfo(UUID uuid, UserInfoUpdateDto userUpdateDto) throws ObjectNotFoundException;
}
