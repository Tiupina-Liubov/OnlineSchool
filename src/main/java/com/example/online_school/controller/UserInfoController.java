package com.example.online_school.controller;

import com.example.online_school.annotation.GetUserInfo;
import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user_infos")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetUserInfo(path = "/get/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") UUID id) throws IdNotFoundException {
        return userInfoService.getUserInfoById(id);
    }

    @PostMapping("/create")
    public UserInfoAfterCreationDto createUserInfo(@RequestBody UserInfoCreateDto userInfoCreateDto) throws ObjectAlreadyExistsException {
        return userInfoService.createUserInfo(userInfoCreateDto);
    }

    //TODO Сделать контролер update
}
