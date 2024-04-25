package com.example.online_school.service.impl;

import com.example.online_school.entity.Role;
import com.example.online_school.entity.enums.RoleName;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    public final RoleRepository roleRepisitory;
    @Override
    public Role getRoleById(UUID id) {
        Role role= roleRepisitory.getRoleById(id);
        if(role!=null){
           return role;
        }else {
            throw new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }

    }



    @Override
    public Role getRoleByRoleName(RoleName roleName) throws ObjectAlreadyExistsException {
        List<Role> roles = roleRepisitory.findAll();
//        for (Role r : roles) {
//            if (r.getRoleName().equals(roleName)) {
//                return r;
//            }else {
//                throw new ObjectAlreadyExistsException(ErrorMassage.ROLE_ALREADY_EXISTS);
//            }
//        }
//    }

        return roles.stream()
                .filter(role -> role.getRoleName().equals(roleName))
                .limit(1)
                .findAny()
                .orElseThrow(()->new ObjectAlreadyExistsException(ErrorMassage.ROLE_ALREADY_EXISTS));
}


    @Override
    public List<Role> getAllRoles() {
        return roleRepisitory.findAll();
    }
}
