package com.example.online_school.mapper;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;

import org.mapstruct.*;


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
     default void createdUserInfo(@MappingTarget User user, UserCreateDto userCreateDto){
        UserInfo userInfo= new UserInfo();
        userInfo.setEmail(userCreateDto.getEmail());
        userInfo.setPassword(userCreateDto.getPassword());
        userInfo.setUsername(userCreateDto.getUsername());
        userInfo.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setUserInfo(userInfo);

    }

    @Mapping(target = "id", source = "id")
    UserAfterCreationDto toDo(User userAfterCreation);


//    default String mapRoles(Set<Role> roles) {
//        if (roles == null || roles.isEmpty()) {
//            return null;
//        }
//        return roles.stream()
//                .map(Role::getRoleName)
//                .map(Enum::name)
//                .collect(Collectors.joining(","));
}
