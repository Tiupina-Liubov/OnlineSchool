package com.example.online_school.service;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoAfterUpdateDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.dto.UserInfoUpdateDto;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;

import java.util.UUID;

public interface UserInfoService {

    UserInfo getUserInfoById(UUID id);

    UserInfoAfterCreationDto createUserInfo(UserInfoCreateDto userCreateDto) throws ObjectAlreadyExistsException;

    UserInfoAfterUpdateDto updateUserInfo(UUID uuid, UserInfoUpdateDto userUpdateDto) throws ObjectNotFoundException;
}
