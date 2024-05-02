package com.example.online_school.service.impl;

import com.example.online_school.entity.Account;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.mapper.UserMapper;
import com.example.online_school.repository.AccountRepository;
import com.example.online_school.repository.RoleRepository;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.repository.UserRepository;
import com.example.online_school.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.UUID;

//@Service
//@RequiredArgsConstructor
//public class AccountServiceImpl implements AccountService {
//
//    private final AccountRepository accountRepository;
//    private final UserRepository userRepository;
//    private final UserInfoRepository userInfoRepository;
//    private final UserMapper userMapper;
//    private final RoleRepository roleRepository;
//
//    @Override
//    public Account getAccountById(UUID id) throws AccountNotFoundException {
//        Account account = accountRepository.findById(id).orElse(null);
//
//        if (account == null) {
//            throw new AccountNotFoundException(ErrorMassage.ACCOUNT_NOT_FOUND);
//        }
//        return account;
//    }
//}
