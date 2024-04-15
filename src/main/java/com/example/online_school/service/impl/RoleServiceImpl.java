package com.example.online_school.service.impl;

import com.example.online_school.entity.Role;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
