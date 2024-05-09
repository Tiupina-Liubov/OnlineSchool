package com.example.online_school.mapper;

import com.example.online_school.dto.RoleAfterCreateDto;
import com.example.online_school.dto.RoleCreateDto;
import com.example.online_school.entity.Role;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    @Mappings({
            @Mapping(target = "roleName", source = "roleName"),
            @Mapping(target = "authorities", source = "authorities"),
    })
    Role toEntity(RoleCreateDto roleCreateDto);

    @Mapping(target = "id", source = "id")
    RoleAfterCreateDto toDo(Role roleAfterCreateDto);
}
