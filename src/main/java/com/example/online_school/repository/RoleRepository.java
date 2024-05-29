package com.example.online_school.repository;

import com.example.online_school.entity.Role;
import com.example.online_school.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for Role entities.
 *
 * Интерфейс репозитория для сущностей Role.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    /**
     * Retrieves a Role entity by its ID.
     *
     * Получает сущность Role по ее идентификатору.
     *
     * @param id The ID of the Role entity.
     * @return The Role entity.
     */
    Role getRoleById(UUID id);

    /**
     * Retrieves a Role entity by its role name.
     *
     * Получает сущность Role по ее имени роли.
     *
     * @param roleName The name of the role.
     * @return The Role entity.
     */
    Role getRoleByRoleName(RoleName roleName);

}
