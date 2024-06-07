package com.example.online_school.service.impl;

import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.entity.enums.RoleName;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of the RoleService interface.
 *
 * Реализация интерфейса RoleService.
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    /**
     * Retrieves a Role entity by its ID.
     *
     * Получает сущность Role по ее идентификатору.
     *
     * @param id The ID of the Role entity.
     * @return The Role entity.
     * @throws IdNotFoundException if no Role entity with the given ID is found.
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Role getRoleById(UUID id) {
        Role role = roleRepository.getRoleById(id);
        if (role != null) {
            return role;
        } else {
            throw new IdNotFoundException(ErrorMessage.ID_NOT_FOUND);
        }
    }

    /**
     * Retrieves all Role entities.
     *
     * Получает все сущности Role.
     *
     * @return The list of Role entities.
     * @throws ObjectNotFoundException if no Role entities are found.
     */
    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Role> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        if (!roles.isEmpty()) {
            return roleRepository.findAll();
        } else {
            throw new ObjectNotFoundException(ErrorMessage.ROLES_NOT_FOUND);
        }
    }

    @Override
    public boolean addRoleByRoleName(String roleName) throws ObjectAlreadyExistsException {
        Role role = roleRepository.getRoleByRoleName(RoleName.valueOf(roleName));
        return false;
    }
}
