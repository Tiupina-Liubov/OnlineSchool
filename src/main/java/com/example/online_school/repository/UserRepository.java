package com.example.online_school.repository;

import com.example.online_school.entity.User;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User getUserById(UUID id);

    @Query("SELECT u FROM User u JOIN u.userInfo.roles r WHERE r = :role")
    Set<User> findUsersByRole(@Param("role") String role);


    @Query("SELECT email from UserInfo ")
    Optional<Set<String>> findAllEmail();

    @Query("SELECT username from UserInfo ")
    Optional<Set<String>> findAllUsername();
}
