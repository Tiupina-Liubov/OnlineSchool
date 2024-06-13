package com.example.online_school.security;

import com.example.online_school.entity.Role;
import com.example.online_school.entity.UserInfo;
import com.example.online_school.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.springframework.security.core.userdetails.User.withUsername;

/**
 * Service implementation for loading user-specific data.
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;

    /**
     * Loads the user details by username.
     *
     * @param username the username identifying the user whose data is required
     * @return a fully populated {@link UserDetails} object
     * @throws UsernameNotFoundException if the user could not be found
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findUserByUsername(username);

        if (userInfoOptional.isEmpty()) {
            throw new UsernameNotFoundException("User with login '" + username + "' not found");
        }

        UserInfo userInfo = userInfoOptional.get();

        return withUsername(userInfo.getUsername())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .authorities(getAuthorities(userInfo.getRoles()))
                .build();
    }

    /**
     * Returns the authorities granted to the user.
     *
     * @param roles the collection of roles associated with the user
     * @return a collection of granted authorities
     */
    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().name()));

            role.getAuthorities().forEach(authority ->
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName().name()))
            );
        }
        return authorities;
    }
}
