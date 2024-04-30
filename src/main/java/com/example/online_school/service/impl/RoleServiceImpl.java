package com.example.online_school.service.impl;

import com.example.online_school.dto.RoleAfterCreateDto;
import com.example.online_school.dto.RoleCreateDto;
import com.example.online_school.entity.Role;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.mapper.RoleMapper;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    public final RoleRepository roleRepository;

    public final RoleMapper roleMapper;
    @Override
    public Role getRoleById(UUID id) {
        Role role= roleRepository.getRoleById(id);
        if(role!=null){
           return role;
        }else {
            throw new IdNotFoundException(ErrorMassage.ID_NOT_FOUND);
        }

    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleAfterCreateDto createRole(RoleCreateDto roleCreateDto) throws ObjectAlreadyExistsException {
        Role role= roleRepository.getRoleByRoleName(roleCreateDto.getRoleName());
       if(role!=null){
           throw new ObjectAlreadyExistsException(ErrorMassage.ROLE_ALREADY_EXISTS);
       }
       Role entity =roleMapper.toEntity(roleCreateDto);
       Role roleAfterCreateDto= roleRepository.save(entity);
       return roleMapper.toDo(roleAfterCreateDto);
    }
}
