package com.example.online_school.repository;

import com.example.online_school.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role,UUID> {

    Role getRoleById(UUID id);
}
