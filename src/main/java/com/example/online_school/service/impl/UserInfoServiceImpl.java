package com.example.online_school.service.impl;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.mapper.UserInfoMapper;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    private  final UserRepository userRepository;// todo спосить правильно ли ето будет

    private final UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoById(UUID id) {

        return userInfoRepository.getUserInfoById(id);
    }


    @Override
    public UserInfoAfterCreationDto createUserInfo(UserInfoCreateDto userInfoCreateDto) throws ObjectAlreadyExistsException {
        // Проверка, существует ли уже пользователь с таким же username
        UserInfo userInfo= userInfoRepository.findUserByEmail(userInfoCreateDto.getEmail());
        if(userInfo!= null){
            throw new ObjectAlreadyExistsException(ErrorMassage.USER_ALREADY_EXISTS ); //todo сделать более понятно "User with username " + userInfoCreateDto.getUsername() + " already exists"
        }
        UserInfo entity = userInfoMapper.toEntity(userInfoCreateDto);
        //todo надо хорошенько подумать над етим
        UserInfo userInfoAfterCreation= userInfoRepository.save(entity);
        System.out.println(userInfoAfterCreation);
        return userInfoMapper.toDo(userInfoAfterCreation);
    }


}

