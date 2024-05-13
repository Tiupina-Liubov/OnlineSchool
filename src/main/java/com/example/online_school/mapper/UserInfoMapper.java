package com.example.online_school.mapper;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.dto.UserInfoUpdateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import org.mapstruct.*;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserInfoMapper {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "salary", ignore = true)
    @Mapping(target = "paymentTribute", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    UserInfo toEntity(UserInfoCreateDto userInfoCreateDto);


    @Mapping(target = "id", source = "id")
    UserInfoAfterCreationDto toDo(UserInfo userInfoCreateDto);

    @Mapping(target = "email", expression = "java(userInfoUpdateDto.getEmail().isEmpty() ? entity.getEmail() :userInfoUpdateDto.getEmail())")
    @Mapping(target = "username",expression = "java(userInfoUpdateDto.getUsername().isEmpty() ? entity.getUsername() :userInfoUpdateDto.getUsername())")
    @Mapping(target = "password",expression = "java(userInfoUpdateDto.getPassword().isEmpty() ? entity.getPassword() :userInfoUpdateDto.getPassword())")
    @Mapping(target = "phoneNumber",expression = "java(userInfoUpdateDto.getPhoneNumber().isEmpty() ? entity.getPhoneNumber() :userInfoUpdateDto.getPhoneNumber())")
    @Mapping(target = "salary", ignore = true)
    @Mapping(target = "paymentTribute", ignore = true)
    UserInfo toEntity(UserInfoUpdateDto userInfoUpdateDto, @MappingTarget UserInfo entity);

    @AfterMapping
    default void updateUserInfoTime(UserInfoUpdateDto userUpdateDto, @MappingTarget UserInfo entity) {
        entity.setUpdateAt(ZonedDateTime.now());
    }

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
