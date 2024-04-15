package com.example.online_school.repository;

import com.example.online_school.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClazzRepository extends JpaRepository<Clazz,UUID> {

    Clazz getClazzById(UUID id);
}
