package com.example.online_school.service.impl;


import com.example.online_school.dto.RoleAfterCreateDto;
import com.example.online_school.dto.RoleCreateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.mapper.RoleMapper;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    public final RoleRepository roleRepository;

    public final RoleMapper roleMapper;

    public final UserInfoRepository userInfoRepository;

    private final UserRepository userRepository;

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

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Role> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        if (!roles.isEmpty()) {
            return roleRepository.findAll();
        } else
            throw new ObjectNotFoundException(ErrorMessage.ROLES_NOT_FOUND);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public RoleAfterCreateDto createRole(RoleCreateDto roleCreateDto) throws ObjectAlreadyExistsException {
        Role role = roleRepository.getRoleByRoleName(roleCreateDto.getRoleName());

        if (role != null ) {
            throw new ObjectAlreadyExistsException(ErrorMessage.ROLE_ALREADY_EXISTS);
        }
        Role entity = roleMapper.toEntity(roleCreateDto);
        Role roleAfterCreateDto = roleRepository.save(entity);

        return roleMapper.toDo(roleAfterCreateDto);
    }

    @Override
    public Set<User> getUsersByRole(String roleName) {
        try {
            return userRepository.findUsersByRole(roleName);
        } catch (Exception e) {
            return Collections.emptySet();
        }
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public String deleteRoleById(UUID id) throws IdNotFoundException {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(ErrorMessage.ROLE_ID_NOT_FOUND));

        List<User> users = new ArrayList<>(userRepository.findUsersByRole(role.toString()));

        if (!users.isEmpty()) {
            for (User user : users) {

                UserInfo userInfo = user.getUserInfo();
                userInfo.getRoles().remove(role);
                userInfoRepository.save(userInfo);
               users.remove(user);
            }
            roleRepository.delete(role);
            return "Role deleted successfully";
        } else {

            roleRepository.delete(role);
            return "Role deleted successfully";
        }
    }

//    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public String deleteRoleById(UUID id) throws IdNotFoundException {
//
//        Role role = roleRepository.findById(id)
//                .orElseThrow(() -> new IdNotFoundException(ErrorMessage.ROLE_ID_NOT_FOUND));
//
//        List<User> users = userRepository.findByRole(role);
//
//        if (!users.isEmpty()) {
//           throw new ObjectAlreadyExistsException(ErrorMessage.USERS_WITH_ROLE_EXIST);
//        } else {
//            roleRepository.delete(role);
//            return "***** Role deleted *****";
//        }
//    }
}

