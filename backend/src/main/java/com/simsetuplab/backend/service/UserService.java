package com.simsetuplab.backend.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.user.User;
import com.simsetuplab.backend.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		Optional<User> user = userRepository.findUserById(id);

		return user.orElseThrow(() -> new NoSuchElementException("User not found"));
	}

	public User addOrUpdateUser(User user) {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());

		user.setPassword(encryptedPassword);

		checkIfUserExists(user);
		return userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	private void checkIfUserExists(User user) {
		Optional<User> takenEmail = userRepository.findUserByEmail(user.getEmail());
		Optional<User> takenUsername = userRepository.findUserByUsername(user.getUsername());

		if (takenEmail.isPresent())
			throw new ApiRequestException("Email is already taken");

		if (takenUsername.isPresent())
			throw new ApiRequestException("This username is already taken");
	}
}
