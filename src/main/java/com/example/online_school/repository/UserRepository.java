package com.example.online_school.repository;

import com.example.online_school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User getUserById(UUID id);

    @Query("SELECT u FROM User u JOIN u.userInfo.roles r WHERE r = :role")
    List<User> findUsersByRole(@Param("role") String role);


    @Query("SELECT email from UserInfo ")
    List<String> findAllEmail();

    @Query("SELECT username from UserInfo ")
    List<String> findAllUsername();
}
