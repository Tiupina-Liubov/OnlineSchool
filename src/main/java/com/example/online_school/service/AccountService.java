package com.example.online_school.service;

import com.example.online_school.dto.AccountAfterCreateDto;
import com.example.online_school.dto.AccountCreateDto;
import com.example.online_school.entity.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.UUID;

public interface AccountService {
     Account getAccountById(UUID id) throws AccountNotFoundException;

     AccountAfterCreateDto createAccount(AccountCreateDto accountCreateDto);
}
