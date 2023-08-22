package com.simsetuplab.backend.model.authentication;

import com.simsetuplab.backend.enumeration.user.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {

	private String token;
	private String username;
	private Role role;
	private Long userId;

}
