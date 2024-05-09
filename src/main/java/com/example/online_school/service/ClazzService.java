package com.example.online_school.service;

import com.example.online_school.entity.Clazz;

import java.util.UUID;

public interface ClazzService {

    Clazz getClazzById(UUID id);

    String deleteClazzById(UUID id);
}
