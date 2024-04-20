package com.example.online_school.service.impl;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.entity.User;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.mapper.UserMapper;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
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
     * @param id
     * @return
     */
    @Override
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
    public UserAfterCreationDto createUser(UserCreateDto userCreateDto) throws ObjectAlreadyExistsException {
        User user= userRepository.findUserByEmail(userCreateDto.getEmail());
        if(user!= null){
            throw new ObjectAlreadyExistsException(ErrorMassage.USER_ALREADY_EXISTS);
        }
        User entity = userMapper.toEntity(userCreateDto);
        User userAfterCreation= userRepository.save(entity);
        return userMapper.toDto(userAfterCreation);
    }
}
