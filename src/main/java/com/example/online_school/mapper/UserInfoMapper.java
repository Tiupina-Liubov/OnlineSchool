package com.example.online_school.mapper;

import com.example.online_school.dto.*;
import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import org.mapstruct.*;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper interface for converting between UserInfo DTOs and entities.
 *
 * Интерфейс маппера для преобразования между DTO и сущностями UserInfo.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserInfoMapper {

    /**
     * Converts UserInfoCreateDto to UserInfo entity.
     *
     * Преобразует UserInfoCreateDto в сущность UserInfo.
     *
     * @param userInfoCreateDto The UserInfoCreateDto object.
     * @return The corresponding UserInfo entity.
     */
    @Mapping(target = "email", source = "email")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "salary", ignore = true)
    @Mapping(target = "paymentTribute", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    UserInfo toEntity(UserInfoCreateDto userInfoCreateDto);

    /**
     * Converts UserInfo entity to UserInfoAfterCreationDto.
     *
     * Преобразует сущность UserInfo в UserInfoAfterCreationDto.
     *
     * @param userInfoCreateDto The UserInfo entity.
     * @return The corresponding UserInfoAfterCreationDto.
     */
    @Mapping(target = "id", source = "id")
    UserInfoAfterCreationDto toDo(UserInfo userInfoCreateDto);

    /**
     * Converts UserInfoUpdateDto to UserInfo entity.
     *
     * Преобразует UserInfoUpdateDto в сущность UserInfo.
     *
     * @param userInfoUpdateDto The UserInfoUpdateDto object.
     * @param entity The UserInfo entity to update.
     * @return The updated UserInfo entity.
     */
    @Mapping(target = "email", expression = "java(userInfoUpdateDto.getEmail() == null || " +
            "userInfoUpdateDto.getEmail().isEmpty() ? entity.getEmail() : userInfoUpdateDto.getEmail())")
    @Mapping(target = "username", expression = "java(userInfoUpdateDto.getUsername() == null || " +
            "userInfoUpdateDto.getUsername().isEmpty() ? entity.getUsername() : userInfoUpdateDto.getUsername())")
    @Mapping(target = "password", expression = "java(userInfoUpdateDto.getPassword() == null || " +
            "userInfoUpdateDto.getPassword().isEmpty() ? entity.getPassword() : userInfoUpdateDto.getPassword())")
    @Mapping(target = "phoneNumber", expression = "java(userInfoUpdateDto.getPhoneNumber() == null || " +
            "userInfoUpdateDto.getPhoneNumber().isEmpty() ? entity.getPhoneNumber() : userInfoUpdateDto.getPhoneNumber())")
    @Mapping(target = "salary", ignore = true)
    @Mapping(target = "paymentTribute", ignore = true)
    @Mapping(target = "updateAt", expression = "java(java.time.ZonedDateTime.now())")
    UserInfo toEntityUserInfoUpdate(UserInfoUpdateDto userInfoUpdateDto, @MappingTarget UserInfo entity);

    /**
     * After mapping hook to update the updateAt field of UserInfo entity.
     *
     * После сопоставления метод для обновления поля updateAt сущности UserInfo.
     *
     * @param userUpdateDto The UserInfoUpdateDto object.
     * @param entity The UserInfo entity.
     */
    @AfterMapping
    default void updateUserInfoTime(UserInfoUpdateDto userUpdateDto, @MappingTarget UserInfo entity) {
        entity.setUpdateAt(ZonedDateTime.now());
    }

    /**
     * Converts UserInfo entity to UserInfoAfterUpdateDto.
     *
     * Преобразует сущность UserInfo в UserInfoAfterUpdateDto.
     *
     * @param userInfoAfterUpdateDto The UserInfo entity.
     * @return The corresponding UserInfoAfterUpdateDto.
     */
    @Mapping(target = "id", source = "id")
    UserInfoAfterUpdateDto toDoUpdate(UserInfo userInfoAfterUpdateDto);

    /**
     * Maps the roles of a user to a comma-separated string.
     *
     * Сопоставляет роли пользователя с разделенными запятой строками.
     *
     * @param roles The set of roles.
     * @return A comma-separated string of role names.
     */
    default String mapRoles(Set<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return null;
        }
        return roles.stream()
                .map(Role::getRoleName)
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }
}
