package com.example.online_school.controller;

import com.example.online_school.annotation.CreateUserInfo;
import com.example.online_school.annotation.GetUserInfo;
import com.example.online_school.annotation.UpdateUserInfo;
import com.example.online_school.annotation.UuidFormatChecker;
import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoAfterUpdateDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.dto.UserInfoUpdateDto;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;
import com.example.online_school.service.UserInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class responsible for handling user information-related HTTP requests.
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user_infos")
public class UserInfoController {

    private final UserInfoService userInfoService;

    /**
     * Retrieves user information by its ID.
     *
     * @param id The ID of the user info to retrieve.
     * @return The user info object.
     * @throws IdNotFoundException if the provided ID does not exist.
     */
    @PreAuthorize("hasRole('USER')")
    @GetUserInfo(path = "/{id}")
    public UserInfo getUserInfoById(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
        return userInfoService.getUserInfoById(UUID.fromString(id));
    }

    /**
     * Creates user information.
     *
     * @param userInfoCreateDto The DTO containing the information for creating user info.
     * @return The DTO containing the information of the newly created user info.
     * @throws ObjectAlreadyExistsException if user info with the same details already exists.
     */
    @PreAuthorize("hasRole('USER')")
    @CreateUserInfo(path = "/create")
    public UserInfoAfterCreationDto createUserInfo(@Valid @RequestBody UserInfoCreateDto userInfoCreateDto) throws ObjectAlreadyExistsException {
        return userInfoService.createUserInfo(userInfoCreateDto);
    }

    /**
     * Updates user information.
     *
     * @param id                The ID of the user info to update.
     * @param userInfoUpdateDto The DTO containing the updated user info.
     * @return The DTO containing the updated user info.
     * @throws ObjectNotFoundException if the user info to update is not found.
     */
    @PreAuthorize("hasRole('USER')")
    @UpdateUserInfo(path = "/update/{id}")
    public UserInfoAfterUpdateDto updateUserInfo(@UuidFormatChecker @PathVariable("id") String id, @Valid @RequestBody UserInfoUpdateDto userInfoUpdateDto) throws ObjectNotFoundException {
        return userInfoService.updateUserInfo(UUID.fromString(id), userInfoUpdateDto);
    }


}
