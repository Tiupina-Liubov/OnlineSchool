package com.example.online_school.repository;

import com.example.online_school.entity.Authority;
import com.example.online_school.entity.enums.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorityRepository  extends JpaRepository<Authority,UUID> {
    Authority getAuthorityById(UUID id);

}
