package com.simsetuplab.backend.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.user.User;
import com.simsetuplab.backend.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findUserById(id);

        return user.orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ApiRequestException("User does not exist");
        }
    }

    public User addOrUpdateUser(User user) {
        checkIfUserIsTaken(user);
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    private void checkIfUserIsTaken(User user) {
        Optional<User> takenEmail = userRepository.findUserByEmail(user.getEmail());
        Optional<User> takenUsername = userRepository.findUserByUsername(user.getUsername());

        if (takenEmail.isPresent())
            throw new ApiRequestException("Email is already taken");

        if (takenUsername.isPresent())
            throw new ApiRequestException("This username is already taken");
    }

}
