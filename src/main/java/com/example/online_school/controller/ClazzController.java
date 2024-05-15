package com.example.online_school.controller;

import com.example.online_school.annotation.GetClass;
import com.example.online_school.annotation.UuidFormatChecker;
import com.example.online_school.entity.Clazz;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.service.ClazzService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClazzController {

    private final ClazzService clazzService;

    @GetClass(path = "/get/{id}")
    public Clazz getClazzById(@UuidFormatChecker @PathVariable("id") String id) throws IdNotFoundException {
     return clazzService.getClazzById(UUID.fromString(id)) ;
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteClazzById(@PathVariable("id") String id) throws IdNotFoundException {
//        return  clazzService.deleteClazzById(UUID.fromString(id));
//    }

}
