package com.example.online_school.controller;

import com.example.online_school.annotation.*;
import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.entity.User;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class responsible for handling user-related HTTP requests.
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Retrieves user information by its ID.
     *
     * @param id The ID of the user to retrieve
     * @return The user object.
     */
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetUser(path = "/{id}")
    public User getUserById(@UuidFormatChecker @PathVariable("id") String id) {
        return userService.getUserById(UUID.fromString(id));
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     * @return A message indicating the success of the operation.
     */
    @PreAuthorize("hasRole('USER')")
    @DeleteUser(path = "/delete/{id}")
    public String deleteUserByID(@UuidFormatChecker @PathVariable("id") String id) {

        return userService.deleteUserById(UUID.fromString(id));
    }

    /**
     * Updates a user's information.
     *
     * @param id            The ID of the user to update.
     * @param userUpdateDto The DTO containing the updated user information.
     * @return The DTO containing the updated user information.
     */
    @PreAuthorize("hasRole('USER')")
    @UpdateUser(path = "/update/{id}/")
    public UserAfterUpdateDto updateUser(@UuidFormatChecker @PathVariable("id") String id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
        userUpdateDto.setPassword(passwordEncoder.encode(userUpdateDto.getPassword()));//todo не роботает коректно @Valid при обновлении даных
        return userService.updateUser(UUID.fromString(id), userUpdateDto);
    }

    /**
     * Creates a new user.
     *
     * @param userCreateDto The DTO containing the information for creating the new user.
     * @return The DTO containing the information of the newly created user.
     * @throws ObjectAlreadyExistsException if a user with the same details already exists.
     */
    @PreAuthorize("isAnonymous()")
    @CreateUser(path = "/registration")
    public UserAfterCreationDto createUser(@Valid @RequestBody UserCreateDto userCreateDto) throws ObjectAlreadyExistsException {
        userCreateDto.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        return userService.createUser(userCreateDto);
    }
}


