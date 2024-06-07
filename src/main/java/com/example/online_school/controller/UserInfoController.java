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
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class responsible for handling user information-related HTTP requests.
 *
 * Класс контроллера, отвечающий за обработку HTTP-запросов, связанных с информацией о пользователе.
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
     * Получает информацию о пользователе по его идентификатору.
     *
     * @param id The ID of the user info to retrieve.
     *           Идентификатор информации о пользователе для извлечения.
     * @return The user info object.
     *         Объект информации о пользователе.
     * @throws IdNotFoundException if the provided ID does not exist.
     *                             если предоставленный идентификатор не существует.
     */
    @PreAuthorize("hasAuthority('USER')")
    @GetUserInfo(path = "/{id}")
    public UserInfo getUserInfoById(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
        return userInfoService.getUserInfoById(UUID.fromString(id));
    }

    /**
     * Creates user information.
     *
     * Создает информацию о пользователе.
     *
     * @param userInfoCreateDto The DTO containing the information for creating user info.
     *                           DTO, содержащий информацию для создания информации о пользователе.
     * @return The DTO containing the information of the newly created user info.
     *         DTO, содержащий информацию о только что созданной информации о пользователе.
     * @throws ObjectAlreadyExistsException if user info with the same details already exists.
     *                                      если информация о пользователе с такими же данными уже существует.
     */
    @PreAuthorize("hasAuthority('USER')")
    @CreateUserInfo(path = "/create")
    public UserInfoAfterCreationDto createUserInfo(@Valid @RequestBody UserInfoCreateDto userInfoCreateDto) throws ObjectAlreadyExistsException {
        return userInfoService.createUserInfo(userInfoCreateDto);
    }

    /**
     * Updates user information.
     *
     * Обновляет информацию о пользователе.
     *
     * @param id The ID of the user info to update.
     *           Идентификатор информации о пользователе для обновления.
     * @param userInfoUpdateDto The DTO containing the updated user info.
     *                           DTO, содержащий обновленную информацию о пользователе.
     * @return The DTO containing the updated user info.
     *         DTO, содержащий обновленную информацию о пользователе.
     * @throws ObjectNotFoundException if the user info to update is not found.
     *                                  если информация о пользователе для обновления не найдена.
     */
    @PreAuthorize("hasAuthority('USER')")
    @UpdateUserInfo(path = "/update/{id}")
    public UserInfoAfterUpdateDto updateUserInfo( @UuidFormatChecker  @PathVariable("id")String id,@Valid @RequestBody UserInfoUpdateDto userInfoUpdateDto) throws ObjectNotFoundException {
        return userInfoService.updateUserInfo(UUID.fromString(id), userInfoUpdateDto);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("addRole/{id}")
    public UserInfo addRoleByRoleName( @UuidFormatChecker  @PathVariable("id")String id, @RequestBody String roleName){
        return userInfoService.addRoleByRoleName(UUID.fromString(id),roleName);

    }

}
