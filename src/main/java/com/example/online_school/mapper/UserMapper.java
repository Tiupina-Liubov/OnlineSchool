package com.example.online_school.mapper;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "userInfo.email", source = "userInfo.email")
    @Mapping(target = "userInfo.username", source = "userInfo.username")
    @Mapping(target = "userInfo.password", source = "userInfo.password")
    @Mapping(target = "userInfo.phoneNumber", source = "userInfo.phoneNumber")
    User toEntity(UserCreateDto userCreateDto);

    @Mapping(target = "id",source = "id")
    UserAfterCreationDto toDo(User userAfterCreation);
}
