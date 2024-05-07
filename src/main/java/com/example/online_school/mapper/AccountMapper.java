package com.example.online_school.mapper;

import com.example.online_school.dto.AccountAfterCreateDto;
import com.example.online_school.dto.AccountCreateDto;
import com.example.online_school.entity.Account;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {



    @Mappings({
            @Mapping(target = "user.firstName",source = "firstName"),
            @Mapping(target = "user.lastName", source = "lastName"),
            @Mapping(target = "user.birthday", source = "birthday"),
            @Mapping(target = "user.userInfo.email", source = "email"),
            @Mapping(target = "user.userInfo.username", source = "username"),
            @Mapping(target = "user.userInfo.password", source = "password"),
            @Mapping(target = "user.userInfo.phoneNumber", source = "phoneNumber"),
            @Mapping(target = "user.userInfo.salary", ignore = true),
            @Mapping(target = "user.userInfo.paymentTribute", ignore = true)
    })
   Account toEntity (AccountCreateDto accountCreateDto);


   AccountAfterCreateDto toDo(Account accountAfterCreateDto);
}
