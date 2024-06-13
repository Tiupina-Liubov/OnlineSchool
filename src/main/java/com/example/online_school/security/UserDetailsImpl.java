package com.example.online_school.security;

import com.example.online_school.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Implementation of {@link UserDetails} for Spring Security, representing a user and their granted authorities.
 */
public class UserDetailsImpl implements UserDetails {

    private final User user;

    /**
     * Constructs a new {@code UserDetailsImpl} with the specified user.
     *
     * @param user the user to be represented by this {@code UserDetailsImpl}
     */
    public UserDetailsImpl(User user) {
        this.user = user;
    }

    /**
     * Returns the authorities granted to the user. This method maps the user's roles to {@link SimpleGrantedAuthority}.
     *
     * @return a collection of granted authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getUserInfo().getRoles().stream()
                .flatMap(role -> Arrays.stream(role.getRoleName().name().split(",")))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return user.getUserInfo().getPassword();
    }

    /**
     * Returns the username used to authenticate the user.
     *
     * @return the username
     */
    @Override
    public String getUsername() {
        return user.getUserInfo().getUsername();
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be authenticated.
     *
     * @return {@code true} if the user's account is valid (i.e., non-expired), {@code false} if no longer valid (i.e., expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be authenticated.
     *
     * @return {@code true} if the user is not locked, {@code false} otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired credentials prevent authentication.
     *
     * @return {@code true} if the user's credentials are valid (i.e., non-expired), {@code false} if no longer valid (i.e., expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be authenticated.
     *
     * @return {@code true} if the user is enabled, {@code false} otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
