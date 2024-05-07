package com.example.online_school.mapper;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.entity.UserInfo;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserInfoMapper {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "salary", ignore = true)
    @Mapping(target = "paymentTribute", ignore = true)
    UserInfo toEntity(UserInfoCreateDto userInfoCreateDto);


    @Mapping(target = "id", source = "id")
    UserInfoAfterCreationDto toDo(UserInfo userInfoCreateDto);



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
