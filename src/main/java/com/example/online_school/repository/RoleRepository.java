package com.example.online_school.repository;

import com.example.online_school.entity.Role;
import com.example.online_school.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Role getRoleById(UUID id);

    Role getRoleByRoleName(RoleName roleName);
}
