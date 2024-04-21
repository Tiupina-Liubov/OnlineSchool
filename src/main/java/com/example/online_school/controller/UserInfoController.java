package com.example.online_school.controller;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.service.UserInfoService;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user_info")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/get/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") UUID id) {
        return userInfoService.getUserInfoById(id);
    }

    @PostMapping("/create")
    public UserInfoAfterCreationDto createUserInfo(@RequestBody UserInfoCreateDto userInfoCreateDto) throws ObjectAlreadyExistsException {
        return userInfoService.createUserInfo(userInfoCreateDto);
    }
}
