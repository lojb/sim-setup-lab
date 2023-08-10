package com.simsetuplab.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
		return userRepository.findUserById(id);
	}

	public User addOrUpdateUser(User user) {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());

		user.setPassword(encryptedPassword);

		return userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}
