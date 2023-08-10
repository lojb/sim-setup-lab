package com.simsetuplab.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simsetuplab.backend.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserById(Long id);

	User findUserByUsername(String username);

	User findUserByEmail(String email);
}
