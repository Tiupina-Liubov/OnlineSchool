package com.example.online_school.controller;

import com.example.online_school.entity.Authority;
import com.example.online_school.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/authority")
//public class AuthorityController {
//
//    private final AuthorityService authorityService;
//
//    @GetMapping("/get/{id}")
//    public Authority getAuthorityById(@PathVariable("id") UUID id){
//        return authorityService.getAuthorityById(id);
//    }
//
//}
