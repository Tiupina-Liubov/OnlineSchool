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

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    private final UserRepository userRepository;// todo спосить правильно ли ето будет

    private final UserInfoMapper userInfoMapper;

    private final RoleRepository roleRepository;

    @Override
    public UserInfo getUserInfoById(UUID id) throws IdNotFoundException {
        UserInfo userInfo = userInfoRepository.getUserInfoById(id);

        if (userInfo != null) {
            return userInfo;
        } else {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }

    @Override
    public UserInfoAfterCreationDto createUserInfo(UserInfoCreateDto userInfoCreateDto) throws ObjectAlreadyExistsException {
        UserInfo userInfo = userInfoRepository.findUserByEmail(userInfoCreateDto.getEmail());

        if (userInfo != null) {
            throw new ObjectAlreadyExistsException(ErrorMessage.USER_ALREADY_EXISTS); //todo сделать более понятно "User with username " + userInfoCreateDto.getUsername() + " already exists"
        }

        UserInfo entity = userInfoMapper.toEntity(userInfoCreateDto);

        Role userRole = new Role();
        userRole.setRoleName(RoleName.USER);
        userRole = roleRepository.save(userRole);
        entity.setRoles(Collections.singleton(userRole));
        UserInfo userInfoAfterCreation = userInfoRepository.save(entity);

        return userInfoMapper.toDo(userInfoAfterCreation);
    }

    @Override
    public UserInfoAfterUpdateDto updateUserInfo(UUID id, UserInfoUpdateDto userInfoUpdateDto) throws ObjectNotFoundException {
       UserInfo userInfo= userInfoRepository.getUserInfoById(id);

       if (userInfo != null) {
           userInfo= userInfoMapper.toEntityUserInfoUpdate(userInfoUpdateDto,userInfo);
           UserInfo userInfoAfterUpdate = userInfoRepository.save(userInfo);
           return userInfoMapper.toDoUpdate(userInfoAfterUpdate);
       }else {
           throw new ObjectNotFoundException(ErrorMessage.ID_NOT_FOUND);
       }
    }


}

