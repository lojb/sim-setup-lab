package com.simsetuplab.backend.service;

import com.simsetuplab.backend.enumeration.user.Role;
import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.user.User;
import com.simsetuplab.backend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    private final User testUser = User.builder()
            .username("test1")
            .email("test1@test.com")
            .role(Role.USER)
            .password("asd")
            .build();

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void getAllUsersInvokesFindAll() {
        userService.getAllUsers();

        verify(userRepository).findAll();
    }

    @Test
    void getAllUsersNotNull() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertNotNull(result);
    }

    @Test
    void getAllUsersExpectedLength() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(users.size(), result.size());
    }

    @Test
    void addOrUpdateUserInvokesSave() {
        userService.addOrUpdateUser(testUser);

        verify(userRepository).save(testUser);
    }

    @Test
    void addOrUpdateUserReturnsUser() {
        when(userRepository.save(testUser)).thenReturn(testUser);
        User result = userService.addOrUpdateUser(testUser);

        assertEquals(testUser, result);
    }

    @Test
    void getUserByIdInvokesFindUserById() {
        when(userRepository.findUserById(testUser.getId())).thenReturn(Optional.of(testUser));
        userService.getUserById(testUser.getId());

        verify(userRepository).findUserById(testUser.getId());
    }

    @Test
    void getUserByIdReturnsTestUser() {
        when(userRepository.findUserById(testUser.getId())).thenReturn(Optional.of(testUser));
        User result = userService.getUserById(testUser.getId());

        assertEquals(testUser, result);
    }

    @Test
    void getUserByIdThrowsException() {
        Long id = 26L;
        when(userRepository.findUserById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.getUserById(id));
    }

    @Test
    void getUserByUsernameInvokesFindUserByUserName() {
        when(userRepository.findUserByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
        userService.getUserByUsername(testUser.getUsername());

        verify(userRepository).findUserByUsername(testUser.getUsername());
    }

    @Test
    void getUserByUsernameReturnsTestUser() {
        when(userRepository.findUserByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
        User result = userService.getUserByUsername(testUser.getUsername());

        assertEquals(testUser, result);
    }

    @Test
    void getUserByUsernameThrowsException() {
        String username = "nonexistent";
        when(userRepository.findUserByUsername(username)).thenReturn(Optional.empty());


        assertThrows(ApiRequestException.class, () -> userService.getUserByUsername(username));
    }

    @Test
    void deleteUserInvokesDelete() {
        userService.deleteUser(testUser);

        verify(userRepository).delete(testUser);
    }
}