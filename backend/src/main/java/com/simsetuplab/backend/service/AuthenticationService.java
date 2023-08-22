package com.simsetuplab.backend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.simsetuplab.backend.enumeration.user.Role;
import com.simsetuplab.backend.model.authentication.AuthenticationRequest;
import com.simsetuplab.backend.model.authentication.AuthenticationResponse;
import com.simsetuplab.backend.model.authentication.RegisterRequest;
import com.simsetuplab.backend.model.user.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {
		var user = User.builder()
				.username(request.getUsername())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();

		userService.addOrUpdateUser(user);

		return AuthenticationResponse.builder()
				.username(user.getUsername())
				.token(jwtService.generateToken(user))
				.role(user.getRole())
				.userId(user.getId())
				.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(),
						request.getPassword()
				)
		);

		User user = userService.getUserByUsername(request.getUsername());

		return AuthenticationResponse.builder()
				.username(user.getUsername())
				.userId(user.getId())
				.role(user.getRole())
				.token(jwtService.generateToken(user))
				.build();
	}

}
