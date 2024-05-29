package com.example.online_school.service.impl;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoAfterUpdateDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.dto.UserInfoUpdateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.entity.enums.RoleName;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.mapper.UserInfoMapper;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

/**
 * Implementation of the UserInfoService interface.
 *
 * Реализация интерфейса UserInfoService.
 */
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;
    private final UserInfoMapper userInfoMapper;
    private final RoleRepository roleRepository;

    /**
     * Retrieves a UserInfo entity by its ID.
     *
     * Получает сущность UserInfo по ее идентификатору.
     *
     * @param id The ID of the UserInfo entity.
     * @return The UserInfo entity.
     * @throws IdNotFoundException if no UserInfo entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserInfo getUserInfoById(UUID id) throws IdNotFoundException {
        UserInfo userInfo = userInfoRepository.getUserInfoById(id);
        if (userInfo != null) {
            return userInfo;
        } else {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }

    /**
     * Creates a new UserInfo entity.
     *
     * Создает новую сущность UserInfo.
     *
     * @param userInfoCreateDto The DTO containing the information to create the UserInfo entity.
     * @return The DTO containing the information of the created UserInfo entity.
     * @throws ObjectAlreadyExistsException if a UserInfo entity with the same email already exists.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserInfoAfterCreationDto createUserInfo(UserInfoCreateDto userInfoCreateDto) throws ObjectAlreadyExistsException {
        UserInfo userInfo = userInfoRepository.findUserByEmail(userInfoCreateDto.getEmail());
        if (userInfo != null) {
            throw new ObjectAlreadyExistsException(ErrorMessage.USER_ALREADY_EXISTS);
        }

        UserInfo entity = userInfoMapper.toEntity(userInfoCreateDto);

        Role userRole = new Role();
        userRole.setRoleName(RoleName.USER);
        userRole = roleRepository.save(userRole);
        entity.setRoles(Collections.singleton(userRole));

        UserInfo userInfoAfterCreation = userInfoRepository.save(entity);
        return userInfoMapper.toDo(userInfoAfterCreation);
    }

    /**
     * Updates an existing UserInfo entity.
     *
     * Обновляет существующую сущность UserInfo.
     *
     * @param id The ID of the UserInfo entity to update.
     * @param userInfoUpdateDto The DTO containing the updated information.
     * @return The DTO containing the information of the updated UserInfo entity.
     * @throws ObjectNotFoundException if no UserInfo entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserInfoAfterUpdateDto updateUserInfo(UUID id, UserInfoUpdateDto userInfoUpdateDto) throws ObjectNotFoundException {
        UserInfo userInfo = userInfoRepository.getUserInfoById(id);
        if (userInfo != null) {
            userInfo = userInfoMapper.toEntityUserInfoUpdate(userInfoUpdateDto, userInfo);
            UserInfo userInfoAfterUpdate = userInfoRepository.save(userInfo);
            return userInfoMapper.toDoUpdate(userInfoAfterUpdate);
        } else {
            throw new ObjectNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }
}
