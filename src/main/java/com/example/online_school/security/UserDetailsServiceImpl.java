package com.example.online_school.security;

import com.example.online_school.entity.Role;
import com.example.online_school.entity.User;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.repository.UserInfoRepository;
import com.example.online_school.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    public final UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo>userInfo = userInfoRepository.findUserByUsername(username);
        UserInfo info = userInfo.get();

        if (userInfo == null) {
            throw new UsernameNotFoundException("User with login '" + username + "' not found");
        }

        return withUsername(info.getUsername())
                .username(info.getUsername())
                .password(info.getPassword())
                .authorities(getAuthorities(info.getRoles()))
                .build();
    }


   private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> collection) {
       Set<GrantedAuthority> authorities = new HashSet<>();

       for (Role role : collection) {
           authorities.add(new SimpleGrantedAuthority(role.getRoleName().name()));

           role.getAuthorities().forEach(authority ->
                   authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName().name()))
           );
       }
       return authorities;
   }
}