package com.example.online_school.mapper;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.ZonedDateTime;

/**
 * Mapper interface for converting between User DTOs and entities.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Converts UserCreateDto to User entity.я.
     *
     * @param userCreateDto The UserCreateDto object.
     * @return The corresponding User entity.
     */
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

    /**
     * After mapping hook to create UserInfo for User entity.
     *
     * @param user          The User entity.
     * @param userCreateDto The UserCreateDto object.
     */
    @AfterMapping
    default void createdUserInfo(@MappingTarget User user, UserCreateDto userCreateDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(userCreateDto.getEmail());
        userInfo.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        userInfo.setUsername(userCreateDto.getUsername());
        userInfo.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setUserInfo(userInfo);
    }

    /**
     * Converts User entity to UserAfterCreationDto.
     *
     * @param userAfterCreation The User entity.
     * @return The corresponding UserAfterCreationDto.
     */
    @Mapping(target = "id", source = "id")
    UserAfterCreationDto toDo(User userAfterCreation);

    /**
     * Converts UserUpdateDto to User entity.
     *
     * @param userUpdateDto The UserUpdateDto object.
     * @param entity        The User entity to update.
     * @return The updated User entity.
     */
    @Mapping(target = "firstName", expression = "java(userUpdateDto.getFirstName().isEmpty() ? entity.getFirstName() : " +
            "userUpdateDto.getFirstName())")
    @Mapping(target = "lastName", expression = "java(userUpdateDto.getLastName().isEmpty() ? entity.getLastName() :" +
            "userUpdateDto.getLastName())")
    @Mapping(target = "birthday", source = "birthday", nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userInfo.id", ignore = true)
    @Mapping(target = "userInfo.username", ignore = true)
    @Mapping(target = "userInfo.password", ignore = true)
    @Mapping(target = "userInfo.email", ignore = true)
    @Mapping(target = "userInfo.phoneNumber", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", expression = "java(java.time.ZonedDateTime.now())")
    User toEntityUpdate(UserUpdateDto userUpdateDto, @MappingTarget User entity);

    /**
     * After mapping hook to update UserInfo for User entity.
     *
     * @param userUpdateDto The UserUpdateDto object.
     * @param entity        The UserInfo entity.
     */
    @AfterMapping
    default void updateUserInfo(UserUpdateDto userUpdateDto, @MappingTarget UserInfo entity) {
        entity.setUsername(userUpdateDto.getUsername().isEmpty() ? entity.getUsername() : userUpdateDto.getUsername());
        entity.setPassword(userUpdateDto.getPassword().isEmpty() ? entity.getPassword() : userUpdateDto.getPassword());
        entity.setPhoneNumber(userUpdateDto.getPhoneNumber().isEmpty() ? entity.getPhoneNumber() :
                userUpdateDto.getPhoneNumber());
        entity.setEmail(userUpdateDto.getEmail().isEmpty() ? entity.getEmail() : userUpdateDto.getEmail());
        entity.setUpdateAt(ZonedDateTime.now());
    }

    /**
     * Converts User entity to UserAfterUpdateDto.
     *
     * @param userAfterUpdating The User entity.
     * @return The corresponding UserAfterUpdateDto.
     */
    @Mapping(target = "id", source = "id")
    UserAfterUpdateDto toDoUpdate(User userAfterUpdating);


}
