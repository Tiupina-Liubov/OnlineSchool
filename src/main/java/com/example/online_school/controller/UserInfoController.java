package com.example.online_school.controller;

import com.example.online_school.entity.UserInfo;
import com.example.online_school.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user_info")
public class UserInfoController {
    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
@GetMapping("/get/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") UUID id){
        return userInfoService.getUserInfoById(id);
    }
    }
