package com.example.online_school.controller;

import com.example.online_school.dto.AccountAfterCreateDto;
import com.example.online_school.dto.AccountCreateDto;
import com.example.online_school.entity.Account;
import com.example.online_school.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.UUID;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/account")
//public class AccountController {
//
//    private final AccountService accountService;
//
//    @GetMapping("/get/{id}")
//    public Account getAccountById(@PathVariable("id") UUID id) throws AccountNotFoundException {
//        return accountService.getAccountById(id);
//    }
//
//    @PostMapping("/create")
//    public AccountAfterCreateDto createAccount(@RequestBody AccountCreateDto accountCreateDto) {//todo нужно подумать нужна ли мне еще одно сушность в виде акаунта
//        return accountService.createAccount(accountCreateDto);
//    }
//}
