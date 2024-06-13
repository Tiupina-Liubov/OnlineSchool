package com.example.online_school.mapper;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoAfterUpdateDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.dto.UserInfoUpdateDto;
import com.example.online_school.entity.UserInfo;
import org.mapstruct.*;

/**
 * Mapper interface for converting between UserInfo DTOs and entities.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserInfoMapper {

    /**
     * Converts UserInfoCreateDto to UserInfo entity.
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
     * @param userInfoCreateDto The UserInfo entity.
     * @return The corresponding UserInfoAfterCreationDto.
     */
    @Mapping(target = "id", source = "id")
    UserInfoAfterCreationDto toDo(UserInfo userInfoCreateDto);

    /**
     * Converts UserInfoUpdateDto to UserInfo entity.
     *
     * @param userInfoUpdateDto The UserInfoUpdateDto object.
     * @param entity            The UserInfo entity to update.
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
     * Converts UserInfo entity to UserInfoAfterUpdateDto.
     *
     * @param userInfoAfterUpdateDto The UserInfo entity.
     * @return The corresponding UserInfoAfterUpdateDto.
     */
    @Mapping(target = "id", source = "id")
    UserInfoAfterUpdateDto toDoUpdate(UserInfo userInfoAfterUpdateDto);

}
