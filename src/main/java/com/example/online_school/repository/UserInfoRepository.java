package com.example.online_school.repository;

import com.example.online_school.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfo,UUID> {

    UserInfo getUserInfoById(UUID id);

    UserInfo findUserByEmail(String email);
}
