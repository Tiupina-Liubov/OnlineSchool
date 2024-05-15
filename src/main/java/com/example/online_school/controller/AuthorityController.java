package com.example.online_school.controller;

import com.example.online_school.entity.Authority;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authority")
public class AuthorityController {

    private final AuthorityService authorityService;

    @GetMapping("/get/{id}")
    public Authority getAuthorityById(@PathVariable("id") UUID id) throws IdNotFoundException {
        return authorityService.getAuthorityById(id);
    }

}
