package com.example.online_school.mapper;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import org.mapstruct.*;
import org.mapstruct.Named;

import java.time.ZonedDateTime;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "userInfo.email", source = "email")
    @Mapping(target = "userInfo.username", source = "username")
    @Mapping(target = "userInfo.password", source = "password")
    @Mapping(target = "userInfo.phoneNumber", source = "phoneNumber")
    @Mapping(target = "userInfo.salary", ignore = true)
    @Mapping(target = "userInfo.paymentTribute", ignore = true)
    User toEntity(UserCreateDto userCreateDto);

    @AfterMapping
    default void createdUserInfo(@MappingTarget User user, UserCreateDto userCreateDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(userCreateDto.getEmail());
        userInfo.setPassword(userCreateDto.getPassword());
        userInfo.setUsername(userCreateDto.getUsername());
        userInfo.setPhoneNumber(userCreateDto.getPhoneNumber());
       user.setUserInfo(userInfo);
    }

    @Mapping(target = "id", source = "id")
    UserAfterCreationDto toDo(User userAfterCreation);


    @Mapping(target = "firstName", source = "firstName",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,qualifiedByName = "nonEmptyString")
    @Mapping(target = "lastName", source = "lastName",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,qualifiedByName = "nonEmptyString")
    @Mapping(target = "birthday", source = "birthday", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "userInfo.email", source = "email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "userInfo.username", source = "username", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "userInfo.password", source = "password", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "userInfo.phoneNumber", source = "phoneNumber", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "userInfo.salary", ignore = true)
    @Mapping(target = "userInfo.paymentTribute", ignore = true)
    @Mapping(target = "id", ignore = true)
    User toEntity(UserUpdateDto userUpdateDto, @MappingTarget User entity);

    @AfterMapping
    default void updateUserInfo(UserUpdateDto userUpdateDto, @MappingTarget User entity) {
        entity.getUserInfo().setEmail(userUpdateDto.getEmail());
        entity.getUserInfo().setPassword(userUpdateDto.getPassword());
        entity.getUserInfo().setUsername(userUpdateDto.getUsername());
        entity.getUserInfo().setPhoneNumber(userUpdateDto.getPhoneNumber());
        entity.setUpdateAt(ZonedDateTime.now());
    }

    @Mapping(target = "id", source = "id")
    UserAfterUpdateDto toDoUpdate(User userAfterUpdating);

    @Named("nonEmptyString")
    default String nonEmptyString(String string) {
        return (string != null && !string.isEmpty()) ? string : null;
    }

}
