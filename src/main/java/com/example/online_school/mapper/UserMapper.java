package com.example.online_school.mapper;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import org.mapstruct.*;

import java.time.ZonedDateTime;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
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







    @Mapping(target = "firstName", expression = "java(userUpdateDto.getFirstName().isEmpty() ? entity.getFirstName() : userUpdateDto.getFirstName())")
    @Mapping(target = "lastName", expression = "java(userUpdateDto.getLastName().isEmpty() ? entity.getLastName() : userUpdateDto.getLastName())")
    @Mapping(target = "birthday", source = "birthday", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userInfo.id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", expression = "java(java.time.ZonedDateTime.now())")
    User toEntityUpdate(UserUpdateDto userUpdateDto, @MappingTarget User entity);

    @AfterMapping
    default void updateUserInfo(UserUpdateDto userUpdateDto, @MappingTarget UserInfo entity) {
      entity.setUsername( entity.getUsername().isEmpty() ? entity.getUsername() : userUpdateDto.getUsername());
      entity.setPassword( entity.getPassword().isEmpty() ? entity.getPassword() : userUpdateDto.getPassword());
      entity.setPhoneNumber(entity.getPhoneNumber().isEmpty() ? entity.getPhoneNumber() : userUpdateDto.getPhoneNumber());
      entity.setEmail(entity.getEmail().isEmpty() ? entity.getEmail() : userUpdateDto.getEmail());
      entity.setUpdateAt(ZonedDateTime.now());
    }

    @Mapping(target = "id", source = "id")
    UserAfterUpdateDto toDoUpdate(User userAfterUpdating);


}
