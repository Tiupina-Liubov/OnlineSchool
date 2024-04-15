package com.example.online_school.service.impl;

import com.example.online_school.entity.UserInfo;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;

    @Override
    public UserInfo getUserInfoById(UUID id) {

        return userInfoRepository.getUserInfoById(id);
    }

}
