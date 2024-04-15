package com.example.online_school.service;

import com.example.online_school.entity.UserInfo;

import java.util.UUID;

public interface UserInfoService {

    UserInfo getUserInfoById(UUID id);

}
