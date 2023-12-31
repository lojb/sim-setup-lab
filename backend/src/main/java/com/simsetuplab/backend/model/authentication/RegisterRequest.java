package com.simsetuplab.backend.model.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterRequest {

	private String username;
	private String email;
	private String password;

}
