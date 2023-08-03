package com.simsetuplab.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simsetuplab.backend.model.user.User;
import com.simsetuplab.backend.service.UserService;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/profile")
	public Object returnProfile() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PostMapping
	public ResponseEntity<User> addUser(User user) {
		return ResponseEntity.ok(userService.addOrUpdateUser(user));
	}

	@PutMapping
	public ResponseEntity<User> updateUser(User user) {
		return ResponseEntity.ok(userService.addOrUpdateUser(user));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteUser(User user) {
		userService.deleteUser(user);
		return ResponseEntity.ok().build();
	}
}
