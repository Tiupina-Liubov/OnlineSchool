package com.example.online_school.mapper;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.entity.enums.RoleName;
import org.mapstruct.*;
import org.mapstruct.Named;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

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
        Role defaultRole = new Role();
//        defaultRole.setRoleName(mapRoles());// todo надо подумать над етим чтобы не создавать каждый раз новую роль, а передавать уже сушествуишую
        userInfo.setRoles(Collections.singleton(defaultRole));
        user.setUserInfo(userInfo);
    }


    @Mapping(target = "id",source = "id")
    UserAfterCreationDto toDo(User userAfterCreation);


    default String mapRoles(Set<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return null;
        }
        return roles.stream()
                .map(Role::getRoleName)
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

//    @Named("dateToLocalDate")
//    default LocalDate convertDateToLocalDate(Date date) {
//
//        return (date != null) ?date.toLocalDate()  : null;
//    }
}
