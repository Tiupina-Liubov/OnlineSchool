package com.example.online_school.service.impl;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.entity.enums.RoleName;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.mapper.UserMapper;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Implementation of the UserService interface.
 * <p>
 * Реализация интерфейса UserService.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    /**
     * Retrieves a User entity by its ID.
     * <p>
     * Получает сущность User по ее идентификатору.
     *
     * @param id The ID of the User entity.
     * @return The User entity.
     * @throws IdNotFoundException if no User entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User getUserById(UUID id) throws IdNotFoundException {
        User user = userRepository.getUserById(id);
        if (user != null) {
            return user;
        } else {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }

    /**
     * Deletes a User entity by its ID.
     * <p>
     * Удаляет сущность User по ее идентификатору.
     *
     * @param id The ID of the User entity to delete.
     * @return A confirmation message of the deletion.
     * @throws IdNotFoundException if no User entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public String deleteUserById(UUID id) throws IdNotFoundException {
        User user = userRepository.getUserById(id);
        if (user != null) {
            userRepository.deleteById(id);
            return "*****DELETE****";
        } else {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }

    /**
     * Creates a new User entity.
     * <p>
     * Создает новую сущность User.
     *
     * @param userCreateDto The DTO containing the information to create the User entity.
     * @return The DTO containing the information of the created User entity.
     * @throws ObjectAlreadyExistsException if a User entity with the same email already exists.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserAfterCreationDto createUser(UserCreateDto userCreateDto) throws ObjectAlreadyExistsException {
        UserInfo userInfo = userInfoRepository.findUserByEmail(userCreateDto.getEmail());
        if (userInfo != null) {
            throw new ObjectAlreadyExistsException(ErrorMessage.USER_ALREADY_EXISTS);
        }

        User entity = userMapper.toEntity(userCreateDto);
        Role defaultRole = roleRepository.getRoleByRoleName(RoleName.ROLE_USER);
        entity.getUserInfo().getRoles().add(defaultRole);
        User userAfterCreation = userRepository.save(entity);
        return userMapper.toDo(userAfterCreation);
    }

    /**
     * Updates an existing User entity.
     * <p>
     * Обновляет существующую сущность User.
     *
     * @param id            The ID of the User entity to update.
     * @param userUpdateDto The DTO containing the updated information.
     * @return The DTO containing the information of the updated User entity.
     * @throws IdNotFoundException if no User entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserAfterUpdateDto updateUser(UUID id, UserUpdateDto userUpdateDto) throws IdNotFoundException {
        User entity = userRepository.getUserById(id);
        if (entity != null) {
            entity = userMapper.toEntityUpdate(userUpdateDto, entity);
            User userAfterUpdate = userRepository.save(entity);
            return userMapper.toDoUpdate(userAfterUpdate);
        } else {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }
}

