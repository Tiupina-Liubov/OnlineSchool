package com.example.online_school.mapper;

import com.example.online_school.dto.RoleAfterCreateDto;
import com.example.online_school.dto.RoleCreateDto;
import com.example.online_school.entity.Role;
import org.hibernate.annotations.TimeZoneStorageType;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;
import java.util.TimeZone;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    @Mappings({
            @Mapping(target ="roleName",source = "roleName"),
            @Mapping(target = "authorities", source = "authorities"),
    })
    Role toEntity(RoleCreateDto roleCreateDto);

    RoleAfterCreateDto toDo(Role roleAfterCreateDto);
}
