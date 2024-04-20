package com.example.online_school.mapper;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.entity.User;
import com.example.online_school.generatorUuid.UuidTimeSequenceGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "email", source = "email")

    @Mapping(target = "userInfo")
    User toEntity(UserCreateDto userCreateDto);


//    @Mapping(target = "id", source = "id")
    UserAfterCreationDto toDto(User userAfterCreation);
}
