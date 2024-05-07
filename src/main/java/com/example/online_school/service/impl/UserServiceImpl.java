package com.example.online_school.service.impl;


import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;

import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.entity.enums.RoleName;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.mapper.UserInfoMapper;
import com.example.online_school.mapper.UserMapper;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;


    @Override
    @Transactional
    public User getUserById(UUID id) throws IdNotFoundException {
        User user = userRepository.getUserById(id);

        if (user != null) {
            return user;

        } else {
            throw new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }
    }

    /**
     * Метод который удаляет User с базы данных
     *
     */
    @Override
    @Transactional
    public String deleteUserById(UUID id) throws IdNotFoundException {
        User user = userRepository.getUserById(id);

        if (user != null) {
            userRepository.deleteById(id);
            return "*****DELETE****";

        } else {
            throw new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public User updateUserNameById(UUID id, String updateFirstName) throws IdNotFoundException {
        User user = userRepository.getUserById(id);
        if (user != null) {
            user.setFirstName(updateFirstName);
            userRepository.save(user);
            return user;
        } else {
            throw new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public UserAfterCreationDto createUser( @Valid UserCreateDto userCreateDto) throws ObjectAlreadyExistsException {
        UserInfo userInfo = userInfoRepository.findUserByEmail(userCreateDto.getEmail());
        if (userInfo != null) {
          //  logger.error(Попытка создать пользователя с существующим email: {}", userCreateDto.getEmail()))
            throw new ObjectAlreadyExistsException(ErrorMassage.USER_ALREADY_EXISTS);
        }
        User entity = userMapper.toEntity(userCreateDto);
        Role defaultRole = roleRepository.getRoleByRoleName(RoleName.USER);
        entity.getUserInfo().getRoles().add(defaultRole);
        User userAfterCreation = userRepository.save(entity);
       // logger.info("Создание пользователя с email: {}", userCreateDto.getEmail());

        return userMapper.toDo(userAfterCreation);
    }
}



