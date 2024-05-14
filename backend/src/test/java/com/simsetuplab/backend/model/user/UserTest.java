package com.simsetuplab.backend.model.user;

import com.simsetuplab.backend.enumeration.user.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserTest {
    private final User testUser = User.builder()
            .username("test1")
            .email("test1@test.com")
            .role(Role.USER)
            .password("asd123")
            .id(1L)
            .build();

    @Test
    public void getAuthoritiesUserRoleTest() {
        Collection<? extends GrantedAuthority> authorities = testUser.getAuthorities();

        assertTrue(authorities.contains(new SimpleGrantedAuthority(Role.USER.name())));
    }

    @Test
    public void getAuthoritiesSizeTest() {
        Collection<? extends GrantedAuthority> authorities = testUser.getAuthorities();

        assertEquals(1, authorities.size());
    }

    @Test
    public void isAccountNonExpiredTest() {
        assertTrue(testUser.isAccountNonExpired());
    }

    @Test
    public void isAccountNonLocked() {
        assertTrue(testUser.isAccountNonLocked());
    }

    @Test
    public void isCredentialsNonExpired() {
        assertTrue(testUser.isCredentialsNonExpired());
    }

    @Test
    public void isEnabled() {
        assertTrue(testUser.isEnabled());
    }
}
